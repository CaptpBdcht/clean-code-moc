
import {expect} from 'chai';
import 'mocha';
import {Characters} from "../classes/Characters";
import {Faction} from "../classes/Faction";

let character: Characters;
let faction1: Faction;
let faction2: Faction;

beforeEach(() => {
    character  = new Characters("Dmytro");
    faction1 = new Faction("Gang")
    faction2 = new Faction("Bong");
})

describe('Faction test',
    () => {
        it('Should join faction', () => {
            character.joinFaction(faction1);
            expect(character.faction.indexOf(faction1)).not.equal("Gang");
        });

        it('Should leave faction', () => {
            character.joinFaction(faction1);
            character.leaveFaction(faction1);
            expect(character.faction.length).equal(0);
        });

        it('May have a friend', () => {
            faction1.addFriend(faction2);
            expect(faction1.friends[0].factionName).equal(faction2.factionName);
            expect(faction2.friends[0].factionName).equal(faction1.factionName);
        });

        it('Cannot add the same friend', () => {
            faction1.addFriend(faction2);
            faction1.addFriend(faction2);
            expect(faction1.friends.length).equal(1);
        });

        it('Cannot add myself to friend', () => {
            faction1.addFriend(faction1);
            expect(faction1.friends.indexOf(faction1)).equal(-1);
        });

        it('Remove friend', () => {
            faction1.addFriend(faction2);
            faction1.removeFriend(faction2);
            expect(faction1.friends.indexOf(faction2)).equal(-1);
        });

    });