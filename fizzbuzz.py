number = int(input())
if number < 0:
    print("Cannot fizzbuzz negative numbers")
for x in range(1, number):

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