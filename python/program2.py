#Develop a python program to check whether a given number is palindrome or not and also count the number of occurrences of each digit in the input number.
number=int(input("enter the number that you want to check:"))
numberstore=number
number1=str(number)
temp=number
reverse=0
while(number>0):
    digit=number%10
    reverse=reverse*10+digit
    number=number//10
if (temp==reverse):
    print("the given number is palandrome")
    while(numberstore>0):
        digit1=numberstore%10
        print("the ",digit1,"is occurred in a given number",number1.count(str(digit1)))
        numberstore=numberstore//10
else:
    print("the given string is not a palandrome")