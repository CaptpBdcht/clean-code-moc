import { Entity } from './Entity';
import {Faction} from "./Faction";
import {Assembly} from "./Assembly";

// Peut on forcer l'implementation d'une interface a tout ceux qui herite de Character ?
export class Characters extends Entity {

    name: String;
    faction: Faction[];
    role: String = "Character";
    assembly?: Assembly;

    constructor(name: String) {
        super();
        this.name = name;
        this.faction = [];
    }

    heal(target: Characters){
        target.health++;
        return target;
    }

    joinFaction(faction: Faction){
        this.faction.push(faction);
        return this;
    }

    leaveFaction(faction: Faction){
        let indexOfFaction = this.faction.indexOf(faction);
        this.faction.splice(indexOfFaction, 1);
        return this;
    }

    joinAssembly(assembly: Assembly){
        assembly.joinAssembly(this);
    }

    leaveAssembly(){
        this.assembly?.characterLeaveAssembly(this);
        this.assembly = undefined;
    }

    isCharacterAlly(character: Characters){
        let isSameFactionOrAlly = false;
        this.faction.forEach(factionCharacterA => {
            character.faction.forEach(factionCharacterB => {
                if(this.isFactionAlly(factionCharacterA, factionCharacterB)) isSameFactionOrAlly = true;
            });
        });
        return isSameFactionOrAlly;
    }

    isFactionAlly(factionA: Faction, factionB: Faction){
        if(factionA.factionName === factionB.factionName
            && factionA) return true;
        else if(factionA && factionB){
            let indexOfFriend = factionA.friends.indexOf(factionB);
            return indexOfFriend !== -1;
        }else return false;

    }


}


