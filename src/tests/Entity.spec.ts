
import {expect} from 'chai';
import 'mocha';
import {Entity} from "../classes/Entity";

let entity: Entity;

beforeEach(() => {
    entity  = new Entity();
})

describe('Entity test',
    () => {
        it('Should initialize lifestatus to alive', () => {
            expect(entity.lifeStatus).equal("alive");
        });
    });