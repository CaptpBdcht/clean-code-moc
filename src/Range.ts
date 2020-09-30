export class Range {
    numbers: Number[] = [];
    firstBoundary: String;
    lastBoundary: String;
    firstPositionInRange?: number;
    lastPositionInRange?: number;
    firstNumber?: number;
    lastNumber?: number;

    constructor(range: String){
        this.firstBoundary = range[0];
        this.lastBoundary = range[range.length - 1];
        this.initNumbers(range);
        if(!this.checkBoundaries) throw "Invalid boundaries syntax";
    }

    checkBoundaries(range: String): Boolean{
        if(range.indexOf('[') === -1 || range.indexOf('[') === -1)
            return false;
        if(range.indexOf(')') === -1 || range.indexOf(']') === -1)
            return false;
        return true;
    }

    initNumbers(range: String): void {
        this.firstNumber = 1;
        this.lastNumber = Number(range[range.length - 2]);
        if(this.firstBoundary == '(')
            this.firstNumber = Number(range[2]);
        if(this.lastBoundary == ')')
            this.lastNumber = Number(range[range.length - 3]);
        for(let i: number = this.firstNumber; i <= this.lastNumber ; i++){
            this.numbers.push(Number(range[i]));
        }
    }
    
    contains(value: number): Boolean{
        this.firstPositionInRange = 0;
        this.lastPositionInRange = this.numbers.length;
        if(this.firstBoundary == '('){
            this.firstPositionInRange = 1;
        }
        if(this.lastBoundary == ')'){
            this.lastPositionInRange = this.numbers.length - 2;
        }

        for(let i: number = this.firstPositionInRange; i < this.lastPositionInRange ; i++){
            if(this.numbers[i] == value){
                return true;
            }
        }
        return false;
    }

    size(): number {
        let size: number = 0;
        this.firstPositionInRange = 0;
        this.lastPositionInRange = this.numbers.length;
        if(this.firstBoundary == '('){
            this.firstPositionInRange = 1;
        }
        if(this.lastBoundary == ')'){
            this.lastPositionInRange = this.numbers.length - 2;
        }
        for(let i: number = this.firstPositionInRange; i < this.lastPositionInRange ; i++){
            size++;
        }
        return size;
    }

    values(): String {
        let values: String = this.firstBoundary;
        if(this.firstNumber && this.lastNumber){
            for(let i: number = this.firstNumber; i <= this.lastNumber ; i++){
                if(i == this.lastNumber){
                    values = values + i.toString();
                } else {
                    values = values + i.toString() + ',';
                }
            }
        }
        return values + ']';
    }

    endPoints(): String {
        let endpoints = this.firstBoundary;
        if(this.firstNumber && this.lastNumber){
            endpoints = endpoints + this.firstNumber.toString() + ',' + this.lastNumber.toString() + this.lastBoundary;
        }
        return endpoints;
    }
}