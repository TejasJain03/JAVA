#Develop a python program to find a given number is prime or not
number = int(input("Enter the number: ")) 
# If given number is greater than 1
if number > 1:
    # Iterate from 2 to n / 2
    for i in range(2, int(number/2)+1):
        # If num is divisible by any number between
        # 2 and n / 2, it is not prime
        if (number % i) == 0:
            print(number, "is not a prime number")
            break
    else:
        print(number, "is a prime number")
else:
    print(number, "is not a prime number")