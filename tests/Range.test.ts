import {expect} from "chai";
import {Range} from "../Range";

let range1: Range;
let range2: Range;

beforeEach(() => {
    range1 = new Range(false, false, 2, 5);
    range2 = new Range(false, false, 1, 15);
});

describe('Range test',
    () => {
        it('should create Range', () => {
            expect(range1).to.exist;
        });

        it('should have size equal to 4', () => {
            expect(range1.size()).equal(4);
        });

        it('should start at 2', () => {
            range1 = new Range(true, false, 1, 5);
            expect(range1.startValue).equal(2);
        });

        it('should end at 4 ', () => {
            range1 = new Range(true, true, 1, 5);
            expect(range1.endValue).equal(4);
        });

        it('should contains 3 ', () => {
            expect(range1.contains(3)).equal(true);
        });

        it('should not contains 13 ', () => {
            expect(range1.contains(13)).equal(false);
        });

        it('should contains [2,3,4,5] ', () => {
            expect(range2.contains(range1)).equal(true);
        });

        it('should not contains [2,3,4,5] ', () => {
            range2 = new Range(true, true, 1, 5);
            expect(range2.contains(range1)).equal(false);
        });

        /*it('should be [2,3,4]', () => {
            range1 = new Range(true, true, 1, 5);
            expect(range1.values()).equal([2,3,4]);
        });

        it('endPoints should be [2,5] ', () => {
            expect(range1.endPoints()).equal([2,5]);
        });*/

    });