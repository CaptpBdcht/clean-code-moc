import { should } from 'chai';
import { FizzBuzz } from './fizzbuzz';

should();

describe('FizzBuzz should', () => {

    let fizzbuzz: FizzBuzz;

    beforeEach(() => {
        fizzbuzz = new FizzBuzz();
    });

    it('on range 3', () => {
        fizzbuzz.range(3).should.equal(
            '1 2 Fizz'
        );
    });

    it('on range 15', () => {
        fizzbuzz.range(15).should.equal(
            '1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz'
        );
    });

    it('should throw with negative numbers', () => {
        (function () {
            fizzbuzz.range(-42);
        })
        .should.throw('Cannot fizzbuzz negative numbers');
    });
});