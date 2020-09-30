export class Range {

    startValue: number;
    endValue: number;

    constructor(firstBorneIsOpen: boolean, lastBorneIsOpen: boolean, startValue: number, endValue: number) {
        if (firstBorneIsOpen) this.startValue = startValue + 1;
        else this.startValue = startValue;

        if (lastBorneIsOpen) this.endValue = endValue - 1;
        else this.endValue = endValue;
    }

    contains(value: Range)
    contains(value: number)
    contains(value: any) {
        let result: boolean;
        if(typeof value === "number") result = this.containsNumber(value);
        else result = this.containsRange(value);
        return result;
    }

    private containsNumber(value: number){
        for (let i = this.startValue; i <= this.endValue; i++) {
            if (i === value) return true;
        }
        return false;
    }

    private containsRange(rangeValue: Range) {
        if (rangeValue.startValue < this.startValue || rangeValue.endValue > this.endValue) return false;
        else return true;
    }

    size() {
        let size: number = 0;
        for (let i = this.startValue; i <= this.endValue; i++) {
            size++;
        }
        return size;
    }

    values() {
        let listOfRange = [];
        for (let i = this.startValue; i <= this.endValue; i++) {
            listOfRange.push(i);
        }
        return listOfRange;
    }

    endPoints() {
        let endPointsOfRange = [];
        endPointsOfRange.push(this.startValue, this.endValue);
        return endPointsOfRange;
    }

    intersect(secondRange: Range) {
        if (this.startValue > secondRange.endValue || this.endValue < secondRange.startValue) return [];
        let intersectionOfRanges = [];
        for (let i = this.startValue; i <= this.endValue; i++) {
            if (i >= secondRange.startValue && i <= secondRange.endValue) intersectionOfRanges.push(i);
        }
        return intersectionOfRanges;
    }


}