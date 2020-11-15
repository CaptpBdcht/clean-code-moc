import {Assembly} from "./classes/Assembly";
import {Priest} from "./classes/Priest";
import {Warrior} from "./classes/Warrior";

export interface AssemblyMember {
    role: String,
    joinAssembly: (assembly: Assembly) => boolean,
    leaveAssembly: ()=>void,
}