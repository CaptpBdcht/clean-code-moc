package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Assembly {
    private String name;
    public ArrayList<Class<?>> allowedRoles;
    private List<Character> members;
    private Character master;

    public Assembly(String name, ArrayList<Class<?>> allowedRoles){
        this.name = name;
        this.allowedRoles = allowedRoles;
        this.members = new ArrayList<>();
    }

    public boolean addMembers(Character character){
        if(this.allowedRoles.contains(character.getClass())){
            if(!this.members.contains(character)) {
                this.members.add(character);
                checkMaster();
                return true;
            } else {
                System.out.println(character.getName() + " is already member of " + this.name + " assembly.");
                return false;
            }
        } else {
            System.out.println(character.getClass().toString() + " is not allowed to join this assembly.");
        }
        return false;
    }

    public void leave(Character character){
        if(this.members.contains(character)){
            this.members.remove(character);
            if(character==this.master){
                chooseMaster();
            }
        } else {
            System.out.println("Not a member of this assembly.");
        }
    }

    private void setMaster(Character master) {
        this.master = master;
    }

    private void checkMaster(){
        if(this.master==null){
            setMaster(this.members.get(0));
        }
    }

    private void chooseMaster(){
        if(this.members.size()==0){
            setMaster(null);
        } else {
            Random rand = new Random();
            int index = rand.nextInt(this.members.size());
            setMaster(this.members.get(index));
        }
    }

    public String getName(){
        return this.name;
    }

    public Character getMaster() {
        return master;
    }

    public void setName(String name) {
        this.name = name;
    }

}
