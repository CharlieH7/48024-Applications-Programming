oneToNineteen = ["", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "tweleve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"]
twentyToNinety = ["", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"]

number = int(input("Number: "))
num1 = (number % 1000)/100
num2 = (number % 100)/10
num3 = number % 10
num1 = int(num1)
num2 = int(num2)
num3 = int(num3)
LastTwoDigit = number % 100

while number != -1:
    if number == 0:
        print("zero".strip())
    elif number < 20:
        str1 = oneToNineteen[number]
        print(str1.strip())
    elif number >= 20 and number < 100:
        str2 = twentyToNinety[num2] + " " + oneToNineteen[num3]
        print(str2.strip())
    elif number > 99 and number < 1000:
        if num2 == 0 and num3 == 0:
            str3 = oneToNineteen[num1] + " hundred"
            print(str3.strip())
        else:
            if LastTwoDigit < 20:
                str4 = oneToNineteen[num1] + " hundred and " + oneToNineteen[LastTwoDigit]
                print(str4.strip())
            elif LastTwoDigit >= 20 and LastTwoDigit < 100:
                str5 = oneToNineteen[num1] + " hundred and " + twentyToNinety[num2] + " " + oneToNineteen[num3]
                print(str5.strip())
    number = int(input("Number: "))
    num1 = (number % 1000)/100
    num2 = (number % 100)/10
    num3 = number % 10
    num1 = int(num1)
    num2 = int(num2)
    num3 = int(num3)
    LastTwoDigit = number % 100

if number == -1:
    print("Done".strip())
