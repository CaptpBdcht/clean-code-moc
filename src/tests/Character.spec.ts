
import {expect} from 'chai';
import 'mocha';
import {Characters} from "../classes/Characters";

let character: Characters;

beforeEach(() => {
    character  = new Characters("Dmytro");
})

describe('Character test',
    () => {
        it('should initialize name', () => {
            expect(character.name).equal("Dmytro");
        });

        it('should initialize health Character to 100', () => {
            expect(character.health).equal(100);
        });

        it('health should\'nt exceed 100', () => {
            let characterBis = character.heal(character);
            expect(characterBis.health).to.be.lessThan(101);
        });

    });