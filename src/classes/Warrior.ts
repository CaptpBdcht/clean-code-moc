import {Characters} from "./Characters";
import {Utils} from "./Utils";


export class Warrior extends Characters {
    private utils= new Utils();

    constructor(name: String) {
        super(name);
        this.role = "Warrior";
    }

    heal(target: Characters): Characters {
        if(this.name !== target.name) return target;
        else return super.heal(target);
    }

    attack(target: Characters): Characters {
        if(this.isCharacterAlly(target) && this.name != target.name) return target;
        else {
            target.health = target.health - (this.utils.getRandomInt(9));
            return target;
        }
    }
    
}
