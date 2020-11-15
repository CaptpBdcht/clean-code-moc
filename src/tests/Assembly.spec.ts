import {Entity} from "../classes/Entity";
import {expect} from "chai";
import {Assembly} from "../classes/Assembly";
import {Warrior} from "../classes/Warrior";
import {Priest} from "../classes/Priest";

let assembly1: Assembly;
let assembly2: Assembly;
let warrior1: Warrior;
let priest1: Priest;


beforeEach(() => {
    assembly1  = new Assembly("Gang", ["Warrior"]);
    assembly2  = new Assembly("Goulag", ["Priest","Warrior"]);
    warrior1 = new Warrior("Leo");
    priest1 = new Priest("Dmytro");

})

describe('Assembly test',
    () => {
        it('Should join assembly', () => {
            warrior1.joinAssembly(assembly1);
            expect(warrior1.assembly?.name).equal("Gang");
        });

        it('Should leave assembly', () => {
            warrior1.joinAssembly(assembly1);
            warrior1.leaveAssembly();
            expect(warrior1.assembly).to.not.exist;
        });

        it('Should not join ', () => {
            priest1.joinAssembly(assembly1)
            expect(priest1.assembly).to.not.exist;
        });

        it('Should join ', () => {
            priest1.joinAssembly(assembly2)
            expect(priest1.assembly?.name).equal("Goulag");
        });

        it('Should be master', () => {
            warrior1.joinAssembly(assembly1);
            expect(assembly1.master?.name).equal(warrior1.name);
        });

        it('Should not be master', () => {
            warrior1.joinAssembly(assembly2);
            priest1.joinAssembly(assembly2);
            expect(assembly2.master?.name).not.be.equal(priest1.name);
            expect(assembly2.members.indexOf(priest1)).not.be.equal(-1);
        });

        it('Should update Assembly name', () => {
            let newName : String = "Glory";
            warrior1.joinAssembly(assembly1);
            assembly1.updateAssemblyName(warrior1, newName);
            expect(assembly1.name).equal(newName);
        });

        it('Should not update Assembly name', () => {
            let newName : String = "Glory";
            warrior1.joinAssembly(assembly1);
            priest1.joinAssembly(assembly1);
            assembly1.updateAssemblyName(priest1, newName);
            expect(assembly1.name).not.be.equal(newName);
        });

        it('Should update Assembly master', () => {
            warrior1.joinAssembly(assembly2);
            priest1.joinAssembly(assembly2);
            warrior1.leaveAssembly();
            expect(assembly2.master?.name).equal(priest1.name);
        });

    });