import {Range} from "./Range";


var range: Range = new Range(false, false, 2, 5);
var range2: Range = new Range(false, false, 4, 15);
console.log(range2.intersect(range));
