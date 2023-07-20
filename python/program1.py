#Write a python program to fine the best of two test average marks out of three tests marks accepted from the user.
first_marks= int(input("enter the marks of first subject"))
second_marks=int(input("enter the marks of second subject"))
thrid_marks=int(input("enter the marks of the third subject"))
if(first_marks>second_marks):
    if(second_marks>thrid_marks):
        total=first_marks+second_marks
    else:
        total=first_marks+thrid_marks
elif(first_marks>thrid_marks):
    total=first_marks+thrid_marks
else:
    total=second_marks+thrid_marks
avg=total/2
print("The avg of best two marks is:",avg)