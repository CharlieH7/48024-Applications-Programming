# read pattern
characters = input("Character: ")
count = 0

# read loop pattern
while (characters != '.'):
    characters = input("Character: ")

    # if character is a vowel then increment the count
    if (characters == 'a' or characters == 'e' or characters == 'i' or characters == 'o' or characters == 'u'):
        count = count + 1

# output pattern
print("Vowel count =", count)
