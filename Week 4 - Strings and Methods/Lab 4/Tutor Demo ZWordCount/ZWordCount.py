def containsZ(word):
    return "z" in word.lower()


def zWord(sentence):
    count = 0
    sentence = sentence.split()
    for words in sentence:
        if containsZ(words):
            count = count + 1

    return count


def zWords(sentences):
    sum = 0
    for sentence in sentences:
        sum = sum + zWord(sentence.lower())
    return sum


def output(sentences):
    return "Words containing a 'z' = " + str(zWords(sentences))


if __name__ == "__main__":
    sentences = ["green ideas Zleep furiously", "a zebra graZed", "zorro WAZ zore", "I feel snoozy"]
    for sentence in sentences:
        print(sentence)
    print(output(sentences))

