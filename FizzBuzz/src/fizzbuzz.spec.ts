import { should } from 'chai';
import { FizzBuzz } from './fizzbuzz';

should();

describe('FizzBuzz should', () => {

    let fizzbuzz: FizzBuzz;

    beforeEach(() => {
        fizzbuzz = new FizzBuzz();
    });

    describe('when no divisors are given', () => {

        it('generate range until 3', () => {
            fizzbuzz.range(3).should.equal(
                '1 2 Fizz'
            );
        });
    
        it('generate range until 15', () => {
            fizzbuzz.range(15).should.equal(
                '1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz'
            );
        });
    
        it('throw with negative numbers', () => {
            (function () {
                fizzbuzz.range(-42);
            })
            .should.throw('Cannot fizzbuzz negative numbers');
        });
    });

    describe('with divisors', () => {
        it('throw when they are the same', () => {
            (function () {
                fizzbuzz.withDivisors(2, 2)
            }).should.throw('Divisors must be distinct');
        });

        it('throw with ones', () => {
            (function () {
                fizzbuzz.withDivisors(1, 2).range(3);
            })
            .should.throw('Divisors cannot be 1');
        });

        it('throw with negative divisors', () => {
            (function () {
                fizzbuzz.withDivisors(-2, 5).range(3);
            })
            .should.throw('Divisors cannot be negative');
        });

        it('should throw with not prime values', () => {
            (function () {
                fizzbuzz.withDivisors(2, 4).range(3);
            })
            .should.throw('Divisors must be primes');
        });
    });
});