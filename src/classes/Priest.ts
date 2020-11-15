import {Characters} from "./Characters";
import {AssemblyMember} from "../Interface";
import {Assembly} from "./Assembly";
import {Utils} from "./Utils";

export class Priest extends Characters{
    private utils= new Utils();

    constructor(name: String) {
        super(name);
        this.role = "Priest";
    }

    heal(target: Characters): Characters {
        if(this.name !== target.name && this.isCharacterAlly(target)){
            target.health = target.health + (this.utils.getRandomInt(5) + 5) ;
            return target;
        }
        else if(this.name === target.name) return super.heal(target);
        else return target;
    }
}

