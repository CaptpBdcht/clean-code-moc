import { appendFile } from 'fs';

export class Range {
    first_value: number;
    second_value: number;

    constructor(first_value: number, second_value: number) {
        this.first_value = first_value;
        this.second_value = second_value;
      }

    get first_value(): number {
        return this.first_value;
    }
    
    set first_value(first_value: number) {
    if (first_value == null) {
        throw new Error("No number entred");
    }
    
    this.first_value = first_value;
    }

    get second_value(): number {
        return this.second_value;
    }
    
    set second_value(second_value: number) {
    if (second_value == null) {
        throw new Error("No number entred");
    }
    
    this.second_value = second_value;
    }

    displayRange(Range: Range): list{
        var list = [];
        for (let i = Range.first_value; i< Range.second_value; i++) {
            console.log(Range.first_value);
            append.list();
          }
    }
  
    
  }
  