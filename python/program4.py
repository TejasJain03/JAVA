# Write a python program to find a given number is even or odd using functions.
def evenodd(number):
    if (number == 0 | number < 0):
        print("The Entered value is either zero or less than zero")
        exit(0)
    if(number % 2 == 0 ):
        print("the entered number (",number,") is a even number")
    else :
        print("The entered number (",number,") is a odd number")   


numberfromuser = int(input("Enter the number of your choice : "))
evenodd(numberfromuser)