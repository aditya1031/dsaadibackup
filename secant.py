def secant_method(func, x0, x1, tol=1e-6, max_iter=100):
    x_k_minus_1 = x0
    x_k = x1
    for k in range(max_iter):
        f_k_minus_1 = func(x_k_minus_1)
        f_k = func(x_k)
        if f_k == f_k_minus_1:
            raise ValueError("Division by zero in Secant method.")
        x_k_plus_1 = x_k - f_k * (x_k - x_k_minus_1) / (f_k - f_k_minus_1)
        if abs(x_k_plus_1 - x_k) < tol:
            return x_k_plus_1, k + 1 
        x_k_minus_1 = x_k
        x_k = x_k_plus_1
    raise ValueError("Secant method did not converge within the maximum number of iterations.")
if __name__ == "__main__":
    def target_function(x):
        return x**2 - 4
    x0 = 1.0
    x1 = 3.0
    root, iterations = secant_method(target_function, x0, x1)
    print(f"Root found: {root}")
    print(f"Iterations: {iterations}")
