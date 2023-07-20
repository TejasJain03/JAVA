#Write a python program to find the factorial of a given number
def factorail(number):
    if number < 0 :
        print("The number you have enterd  is invalid, please try again")
    if number == 0 | number == 1 :
        return 1
    else :
        return number * factorail(number-1)


numberfromuser = int(input("Enter the number you want to find the factorail for : "))
print("The factorial (",numberfromuser,") : ", factorail(numberfromuser))