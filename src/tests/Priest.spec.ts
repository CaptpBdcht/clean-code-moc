
import {expect} from 'chai';
import 'mocha';
import {Priest} from "../classes/Priest";
import {Warrior} from "../classes/Warrior";
import {Faction} from "../classes/Faction";

let Priest1: Priest;
let Warrior1: Warrior;

beforeEach(() => {
    Priest1 = new Priest("Leo");
    Warrior1 = new Warrior("Dmytro");
})

describe('Priest test', () => {

    it('Priest could heal itself by 1', () => {
        Priest1.health = 90;
        expect(Priest1.heal(Priest1).health).equal(91);
    });

    it('Priest could not heal other Character without being in same Faction', () => {
        let initialHealth = 80;
        Warrior1.health = initialHealth;
        let healedWarrior = Priest1.heal(Warrior1);
        expect(healedWarrior.health).equal(initialHealth);
    });

    it('Priest could heal ally', () => {
        let faction = new Faction("Gang");
        Warrior1.joinFaction(faction);
        Priest1.joinFaction(faction);
        let initialHealth = 80;
        Warrior1.health = initialHealth;
        let healedWarrior = Priest1.heal(Warrior1);
        expect(healedWarrior.health).to.be.at.most(initialHealth + 10);
        expect(healedWarrior.health).to.be.at.least(initialHealth + 5);
    });

});