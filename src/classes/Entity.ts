//Pourquoi pas créer une relation entre entité et class
// C'est à dire déclarer entité en classe abstraite et que charctère hérite de entity et que priest ou warrior herite de character
// Plus on lis le sujet plus il ya d'arborecence qui se crée

export class Entity {

    get health(): number {return this._health;}
    set health(value: number) {
        if(value > 100) this._health = 100;
        else this._health = value;
    }
    get lifeStatus(): String {
        if(this._health > 0) return "alive";
        else return "dead";
    }

    private _health: number;
    private _lifeStatus: String;

    constructor() {
        this._health = 100;
    }


}