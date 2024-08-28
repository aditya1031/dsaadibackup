import numpy as np
import time

# Function definitions
def f_poly(x):
    return x**3 - 6*x**2 + 11*x - 6

def df_poly(x):
    return 3*x**2 - 12*x + 11

def f_trig(x):
    return np.cos(x) - x

# Bisection Method
def bisection_method(f, a, b, tol=1e-6, max_iter=100):
    fa = f(a)
    fb = f(b)
    
    # Debugging statements
    print(f"f({a}) = {fa}, f({b}) = {fb}")

    if fa * fb >= 0:
        raise ValueError("f(a) and f(b) must have opposite signs")
    
    for i in range(max_iter):
        c = (a + b) / 2
        fc = f(c)
        if fc == 0 or (b - a) / 2 < tol:
            return c, i + 1
        if fc * fa > 0:
            a = c
            fa = fc
        else:
            b = c
            fb = fc
    return c, max_iter

# Newton-Raphson Method
def newton_raphson(f, df, x0, tol=1e-6, max_iter=100):
    for i in range(max_iter):
        x1 = x0 - f(x0) / df(x0)
        if abs(x1 - x0) < tol:
            return x1, i + 1
        x0 = x1
    return x1, max_iter

# Secant Method
def secant_method(f, x0, x1, tol=1e-6, max_iter=100):
    for i in range(max_iter):
        if f(x1) - f(x0) == 0:
            raise ValueError("Division by zero in the Secant method")
        x2 = x1 - f(x1) * (x1 - x0) / (f(x1) - f(x0))
        if abs(x2 - x1) < tol:
            return x2, i + 1
        x0, x1 = x1, x2
    return x2, max_iter

# Testing Functions
def test_method_for_function(method, func, x0, x1=None, df=None, method_name="Method"):
    print(f"\nTesting {method_name} on function {func.__name__}:")
    start_time = time.time()
    try:
        if method == "bisection":
            root, iterations = bisection_method(func, x0, x1)
        elif method == "newton_raphson":
            root, iterations = newton_raphson(func, df, x0)
        elif method == "secant":
            root, iterations = secant_method(func, x0, x1)
        end_time = time.time()
        print(f"{method_name}: Root = {root}, Iterations = {iterations}, Time = {end_time - start_time:.6f} seconds")
    except ValueError as e:
        print(e)

# Run tests for all functions
def run_tests():
    # Bisection Method Tests
    test_method_for_function("bisection", f_poly, 1, 3, method_name="Bisection Method")
    test_method_for_function("bisection", f_trig, 0, 1, method_name="Bisection Method")

    # Newton-Raphson Method Tests
    test_method_for_function("newton_raphson", f_poly, 2, df=df_poly, method_name="Newton-Raphson Method")
    test_method_for_function("newton_raphson", f_trig, 0.5, df=lambda x: -np.sin(x) - 1, method_name="Newton-Raphson Method")

    # Secant Method Tests
    test_method_for_function("secant", f_poly, 1, 3, method_name="Secant Method")
    test_method_for_function("secant", f_trig, 0, 1, method_name="Secant Method")

# Run all tests
run_tests()
