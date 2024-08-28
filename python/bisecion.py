def bisection_method(f, a, b, tol=1e-6):
    if f(a) * f(b) >= 0:
        print("The function must have different signs at points a and b.")
        return None

    c = a
    while (b - a) / 2.0 > tol:
        c = (a + b) / 2.0
        if f(c) == 0:
            return c
        elif f(a) * f(c) < 0:
            b = c
        else:
            a = c
    return c

# Example usage
f = lambda x: x**2 - 4
root = bisection_method(f, 0, 3)
print("Root:", root)
