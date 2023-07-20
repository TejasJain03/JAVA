# Develop a python program to find the addition, subtraction, multiplication, division and modular using functions.
def add(a, b):
    return a + b

def subtract(a, b):
    return a - b

def multiply(a, b):
    return a * b

def divide(a, b):
    if b == 0:
        return "Cannot divide by zero!"
    return a / b

def modulo(a, b):
    if b == 0:
        return "Cannot perform modulo with zero!"
    return a % b


# Input two numbers from the user
num1 = float(input("Enter the first number: "))
num2 = float(input("Enter the second number: "))

# Perform operations using the defined functions
result_add = add(num1, num2)
result_subtract = subtract(num1, num2)
result_multiply = multiply(num1, num2)
result_divide = divide(num1, num2)
result_modulo = modulo(num1, num2)

# Print the results
print("Addition:", result_add)
print("Subtraction:", result_subtract)
print("Multiplication:", result_multiply)
print("Division:", result_divide)
print("Modulo:", result_modulo)
