max = 0
count = 0

rainfall = float(input("Rainfall: "))

while rainfall != -1:
    if rainfall == 0:
        count = count + 1
    elif rainfall > 0:
        if count > max:
            max = count
        count = 0
    rainfall = float(input("Rainfall: "))
if count > max:
    max = count

print("Longest dry spell = " + str(max))
