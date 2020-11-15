import {Characters} from "./Characters";
import {Utils} from "./Utils";


export class Assembly {

    private utils = new Utils();
    private allowedRoles: String[];
    name: String;
    master?: Characters;
    members: Characters[];
    

    constructor(name: String, allowedRoles: String[]){
        this.name = name;
        this.members = [];
        this.allowedRoles = allowedRoles;
    }

    canJoinAssembly(role: String){
        return this.allowedRoles.findIndex(allowedRole => {return allowedRole == role}) != -1
    }

    joinAssembly(character: Characters){
        if((this.canJoinAssembly(character.role) && character.assembly === undefined)) {
            character.assembly = this;
            this.members.push(character);
            if (!this.master) this.master = character;
        }
        return character;
    }

    updateAssemblyName(character: Characters, newName : String){
        if(character.name == this.master?.name){
            this.name = newName;
        }
    }

    characterLeaveAssembly(character: Characters){
        this.members.splice(this.members.indexOf(character), 1);
        if (this.master?.name == character.name){
            this.updateAssemblyMaster();
        }
    }

    updateAssemblyMaster(){
        let randomIndex = this.utils.getRandomInt(this.members.length);
        this.master = this.members[randomIndex];
    }

}

