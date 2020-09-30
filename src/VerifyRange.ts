import {Range} from "./Range"

export class VerifyRange implements Range {
    value: number = 3;

contains(value): boolean{
    list = Range.displayRange();
    if (list.contains(value)){
        return true;
    }
    else{
        return false;
    }
}

size(): num{
    list = Range.displayRange();
    size = sizeof(list);
    return size;
}

values() {
    list = Range.displayRange();
    for (values in list) {
        console.log(list[values]);
      }
}

endPoints(){
    list = Range.displayRange();
    console.log(list(sizeof(list)-sizeof(list)+1), list(sizeof(list)-1));
}

containsRange(x: number, y: number){
    list = Range.displayRange();
    i: number = 0;
    for (values in list) {
        if(values == x){
            i++;
        }
        else if(values == y){
            i++;
        }
      }
      if (i == 2){
          return true;
      }
      else{
          return false;
      }

}

}
