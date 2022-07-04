# read pattern
integer = int(input("Value: "))
sum = 0
count = 0

# read loop pattern
while (integer != -1):
    sum = sum + integer
    integer = int(input("Value: "))
    count = count + 1

# output pattern - print only if there's at least one integer with average
#                  rounding up to one decimal place
if (count > 1):
    average = sum / count
    print("Average =", round(average, 1))
