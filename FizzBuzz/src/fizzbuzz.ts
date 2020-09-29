export class FizzBuzzError extends Error {
    constructor() {
        super('Cannot fizzbuzz negative numbers')
    }
}

export class FizzBuzz {
    range(max: number): string {
        this.handleRangeErrors(max);

        return this.arrayOnRange(max)
                    .map(val => this.of(val))
                    .join(' ')
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
            throw new FizzBuzzError();
        }
    }
}