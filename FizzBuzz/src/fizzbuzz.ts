export class FizzBuzzError extends Error {
    constructor(message: string) {
        super(message)
    }
}

export class FizzBuzz {
    private DIVISORS = {
        Fizz: 3, Buzz: 5
    }

    readonly PRIMES_TO_100 = [
        2, 3, 5, 7, 11,
        13, 17, 19, 23, 29,
        31, 37, 41, 43, 47,
        53, 59, 61, 67, 71,
        73, 79, 83, 89, 97
    ];

    range(max: number): string {
        this.handleRangeErrors(max);

        return this.arrayOnRange(max)
                    .map(val => this.of(val))
                    .join(' ')
    }

    withDivisors(fizzDivisor: number, buzzDivisor: number): FizzBuzz {
        this.handleDivisorsErrors(fizzDivisor, buzzDivisor);

        this.DIVISORS.Fizz = fizzDivisor;
        this.DIVISORS.Buzz = buzzDivisor;
        return this;
    }

    private of(value: number): string {
        if (this.divisibleBy15(value)) {
            return 'FizzBuzz'
        }
        else if (this.divisibleBy3(value)) {
            return 'Fizz';
        }
        else if (this.divisibleBy5(value)) {
            return 'Buzz';
        }
        
        return value.toString();
    }

    private divisibleBy3(value: number): boolean {
        return value % 3 === 0;
    }

    private divisibleBy5(value: number): boolean {
        return value % 5 === 0;
    }

    private divisibleBy15(value: number): boolean {
        return this.divisibleBy3(value) && this.divisibleBy5(value);
    }

    private arrayOnRange(range: number): number[] {
        return [...Array(range).keys()].map(v => v+1);
    }

    private handleRangeErrors(max: number): void {
        if (max < 0) {
            throw new FizzBuzzError('Cannot fizzbuzz negative numbers');
        }
    }

    private handleDivisorsErrors(first: number, second: number): void {
        if (first === second) {
            throw new FizzBuzzError('Divisors must be distinct');
        }
        if (first === 1 || second === 1) {
            throw new FizzBuzzError('Divisors cannot be 1');
        }
        if (first < 0 || second < 0) {
            throw new FizzBuzzError('Divisors cannot be negative');
        }
        if (!this.isPrimeUpTo100(first) || !this.isPrimeUpTo100(second)) {
            throw new FizzBuzzError('Divisors must be primes');
        }
    }

    private isPrimeUpTo100(value: number): boolean {
        return this.PRIMES_TO_100.indexOf(value) < 0 
    }
}