#Write a python program to find the Fibonacci series of a given number
def fibonacci(number):
    if (number == 0 | number < 0 ):
        return "error "
    elif number == 1:
        return 0
    elif number == 2:
        return 1 
    else :
        return fibonacci(number-1) + fibonacci(number-2)

numberfromuser = int(input("Enter the number that you want to calculate the fibonacci of: "))    
print("fibonacci(",numberfromuser,"):",fibonacci(numberfromuser))