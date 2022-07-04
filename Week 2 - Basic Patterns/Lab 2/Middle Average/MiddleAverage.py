# read pattern
value = int(input("Value: "))
list = []
list.append(value)
sum = 0

# read loop pattern
while (value != -1):
    value = int(input("Value: "))

    # add to the list if the value entered is not -1
    if (value != -1):
        list.append(value)

# getting minimum and maximum in the list
min = min(list)
max = max(list)

# check to see if there's at least 3 values in the list
# then remove the maximum and minimum from the list
if (len(list) > 3):
    list.remove(min)
    list.remove(max)

    # sum pattern
    for i in list:
        sum = sum + i
    average = sum / len(list)
    
    # output pattern
    print("Middle average = " + str(average))
