package Entities;

import Groups.Assembly;
import Groups.Faction;
import Enum.Role;

import java.util.ArrayList;

public abstract class Character extends Entity {
    private String name;
    private ArrayList<Faction> factions = new ArrayList<Faction>();
    private Assembly assembly;
    Role role;

    private BasicHealer basicHealer = new BasicHealer();
    private BasicAttacker basicAttacker = new BasicAttacker();

    public Character(String name){
        super(100);
        this.name = name;
    }

    public String getName() { return name; }

    public Assembly getAssembly() {
        return assembly;
    }

    public Role getRole() { return this.role; }

    public ArrayList<Faction> getFactions() { return this.factions; }

    public void attack(Entity entity) {
        if(!entity.isAlive()){
            return;
        }

        Character character = (Character) entity;
        if(equals(character) || isAlly(character)){
            return;
        }

        basicAttacker.attack(entity);
    }

    public void heal(Entity entity) {
        Character character;
        if(!entity.isHealable()){
            return;
        }

        character = (Character) entity;
        if(equals(character)){
            basicHealer.heal(character);
            return;
        }

        if(!hasFaction()){
            basicHealer.heal(character);
            return;
        }

        if(isAlly(character)){
            basicHealer.heal(character);
            //return;
        }
    }


    public void joinFaction(Faction faction) {
        faction.addMember(this);
        this.factions.add(faction);
    }

    public void leaveFaction(Faction faction) {
        int index = this.factions.indexOf(faction);
        this.factions.get(index).removeMember(this);
        if (this.factions != null) {
            this.factions.remove(faction);
        }
    }

    public void joinAssembly(Assembly assembly){
        if(!assembly.isAllowed(role)){
            return;
        }

        if(hasAssembly()){
            this.leaveAssembly(assembly);
        }

        assembly.addMember(this);
        this.assembly = assembly;
    }

    public void leaveAssembly(Assembly assembly){
        if(this.assembly != null) {
            assembly.removeMember(this);
            this.assembly = null;
        }
    }

    public boolean hasFaction(){
        return !this.factions.isEmpty();
    }

    public boolean hasAssembly() {
        return this.assembly != null;
    }

    public boolean isAlly(Character character){
        return shareFaction(character) || shareAssembly(character) || isFactionFriend(character) || isAssemblyFriend(character);
    }

    public boolean shareFaction(Character character){
        if (!this.hasFaction()) {
            return false;
        }
        for(Faction faction : this.factions) {
            if (faction.hasMember(character)) {
                return true;
            }
        }
        return false;
    }

    public boolean shareAssembly(Character character){
        return this.hasAssembly() && character.hasAssembly() && this.assembly.equals(character.getAssembly());
    }

    public boolean isAssemblyFriend(Character character){
        return this.hasAssembly() && character.hasAssembly() && this.assembly.hasFriend(character.getAssembly());
    }

    public boolean isFactionFriend(Character character){
        if (!this.hasFaction()) {
            return false;
        }
        for(Faction faction : this.factions) {
            if (faction.hasFriend(character.getFactions())) {
                return true;
            }
        }
        return false;
    }

    public String toString(){
        return " | name : " + this.name + " | HP : " + this.health;
    }
}
