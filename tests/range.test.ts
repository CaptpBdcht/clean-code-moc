import 'mocha';
import { Range } from '../src/Range';
import { assert } from 'chai';

describe('Tests for class \'Range\'', () => {
    let range: Range;
    beforeEach(() =>{
        range = new Range("[1, 8]");
    })

    it('Should contains 8', () => {
        assert.equal(range.contains(8), true, ('Range contains value 8'));
    });

    it('Should not contains 8', () => {
        assert.notEqual(range.contains(8), false, ('Range don\'t contains value 8'));
    });

    it('Should return size of 8', () => {
        assert.equal(range.size(), 8, 'Range size of 8');
    });

    it('Should return [1,2,3,4,5,6,7,8]', () => {
        assert.equal(range.values(), '[1,2,3,4,5,6,7,8]', 'Range values between 1 & 8');
    });

    it('Should return range', () => {
        assert.equal(range.endPoints(), '[1,8]', 'Returns endpoints of range');
    });
});