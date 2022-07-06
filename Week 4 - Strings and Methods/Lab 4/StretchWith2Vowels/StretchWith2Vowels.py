def read_sentence():
    sentence = input("Sentence: ")
    return sentence


def count_the_number_of_matching_words(sentences):
    sum = 0
    sentences = sentences.split()
    for words in sentences:
        if check_2_vowel(words):
            sum = sum + 1
    return sum


def check_2_vowel(words):
    words = words.lower()
    words = words.split("z")
    for word in words:
        if count_vowel(word) == 2:
            return True
    return False


def count_vowel(word):
    count = 0
    word = word.lower()
    for i in word:
        if (contains_vowel(i)):
            count = count + 1
    return count


def contains_vowel(word):
    return "a" in word.lower() or "e" in word.lower() or "i" in word.lower() or "o" in word.lower() or "u" in word.lower()


sentence = ""
sentence = read_sentence()
while sentence != "*":
    print("Matching words = " + str(count_the_number_of_matching_words(sentence)))
    sentence = read_sentence()
print("Done")
