
import {expect} from 'chai';
import 'mocha';
import {Warrior} from "../classes/Warrior";
import {Faction} from "../classes/Faction";

let warrior1: Warrior;
let warrior2: Warrior;

beforeEach(() => {
    warrior1 = new Warrior("Leo");
    warrior2 = new Warrior("Dmytro");
})

describe('Warrior test', () => {

    it('Warrior could heal itself by 1', () => {
        warrior1.health = 90;
        expect(warrior1.heal(warrior1).health).equal(91);
    });

    it('Warrior cannot heal other Character', () => {
        warrior2.health = 90;
        expect(warrior1.heal(warrior2).health).equal(90);
    });
    
    it('Warrior could attack other Character', () => {
        warrior2.health = 90;
        expect(warrior1.attack(warrior2).health).to.be.at.most(90);
    });

    it('Warrior could attack itself', () => {
        warrior1.health = 90
        expect(warrior1.attack(warrior1).health).to.be.at.most(90);
    });

    it('Warrior could not attack ally', () => {
        let faction = new Faction("Gang");
        warrior2.joinFaction(faction);
        warrior1.joinFaction(faction);
        expect(warrior1.attack(warrior2).health).equal(100);
    });

});