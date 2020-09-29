
numberstart = float(input())
numberend = float(input())

if numberstart < 1:
    print("Cannot fizzbuzz negative numbers")
elif numberstart > 100:
    print("Number to big")
if numberend < 1:
    print("Cannot fizzbuzz negative numbers")
elif numberend > 100:
    print("Number to big")
if numberend > numberstart:
    print("Divisor must be a prime")

for x in range(int(numberstart), int(numberend)):

    fizz = not x % 3
    buzz = not x % 5

    if fizz and buzz:
        print("FizzBuzz ", end='')
    elif fizz:
        print("Fizz ",  end='')
    elif buzz:
        print("Buzz ",  end='')
    else:
        print(x, " ",  end='')