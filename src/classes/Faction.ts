import { ServerRequest } from 'http';
import {Characters} from "./Characters";

export class Faction {
    factionName: string;

    friends: Faction[];

    addFriend(friend: Faction) {
        if(this.friends.indexOf(friend) === -1 && this.factionName !== friend.factionName){
            this.friends.push(friend);
            friend.friends.push(this);    
        }else return;
    }

    removeFriend(friend: Faction){
        let indexOfFriend = this.friends.indexOf(friend);
        if (indexOfFriend !== -1){
            this.friends.splice(indexOfFriend, 1);
            friend.friends.splice(friend.friends.indexOf(this), 1);
        }else return;
    }

    constructor(name: string) {
        this.factionName = name;
        this.friends = [];
    }
}
