month = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

# sum pattern
sum = 0
for i in month:
    sum += i

average = sum / len(month)

# output pattern
print("Average days per month = " + str(average))

