#Write a python program that accepts a sentence and find the number of words, digits, uppercase letters and lowercase letters.
def count_words(sentence):
    words = sentence.split()
    return len(words)

def count_digits(sentence):
    digits = [char for char in sentence if char.isdigit()]
    return len(digits)

def count_uppercase_letters(sentence):
    uppercase_letters = [char for char in sentence if char.isupper()]
    return len(uppercase_letters)

def count_lowercase_letters(sentence):
    lowercase_letters = [char for char in sentence if char.islower()]
    return len(lowercase_letters)


# Input a sentence from the user
sentence = input("Enter a sentence: ")

# Call the functions to count words, digits, uppercase letters, and lowercase letters
word_count = count_words(sentence)
digit_count = count_digits(sentence)
uppercase_count = count_uppercase_letters(sentence)
lowercase_count = count_lowercase_letters(sentence)

# Print the results
print("Number of words:", word_count)
print("Number of digits:", digit_count)
print("Number of uppercase letters:", uppercase_count)
print("Number of lowercase letters:", lowercase_count)
