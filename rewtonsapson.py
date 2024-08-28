def newton_raphson(f, df, x0, tol=1e-6, max_iter=100):
    x = x0
    for _ in range(max_iter):
        fx = f(x)
        dfx = df(x)
        if dfx == 0:
            print("Derivative is zero. No solution found.")
            return None
        x_new = x - fx / dfx
        if abs(x_new - x) < tol:
            return x_new
        x = x_new
    print("Maximum number of iterations reached. No solution found.")
    return None

# Example usage
f = lambda x: x**2 - 4
df = lambda x: 2 * x
initial_guess = 3
root = newton_raphson(f, df, initial_guess)
print("Root:", root)
