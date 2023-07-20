#Write a python program to find the string similarity between two given strings.
def string_similarity(str1, str2):
    common_characters = set(str1) & set(str2)
    total_characters = set(str1) | set(str2)
    similarity = len(common_characters) / len(total_characters)
    return similarity


# Input two strings from the user
string1 = input("Enter the first string: ")
string2 = input("Enter the second string: ")

# Call the function to calculate the string similarity and store the result in 'similarity_score'
similarity_score = string_similarity(string1, string2)

# Print the string similarity
print("String similarity:", similarity_score)
