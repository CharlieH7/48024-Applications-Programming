def read_sentence():
    sentence = input("String: ")
    return sentence


def zCount(s):
    count = 0
    for i in s:
        if i == 'z' or i == 'Z':
            count = count + 1
    return "z count = " + str(count)


if __name__ == "__main__":
    sentence = read_sentence()
    print(zCount(sentence))
