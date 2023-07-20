#Develop a python program to convert the binary to decimal, octal to hexadecimal using functions.
def binary_to_decimal(binary_num):
    decimal_num = int(binary_num, 2)
    return decimal_num

def octal_to_hexadecimal(octal_num):
    decimal_num = int(octal_num, 8)
    hexadecimal_num = hex(decimal_num)[2:].upper()
    return hexadecimal_num


# Input binary and octal numbers from the user
binary_number = input("Enter a binary number: ")
octal_number = input("Enter an octal number: ")

# Call the functions to convert binary to decimal and octal to hexadecimal
decimal_number = binary_to_decimal(binary_number)
hexadecimal_number = octal_to_hexadecimal(octal_number)

# Print the results
print("Decimal equivalent of binary number:", decimal_number)
print("Hexadecimal equivalent of octal number:", hexadecimal_number)
