/*
This class is for creating pets to be stored in the data base
 */
package petdatabase;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nolan Harre
 */
public class Pet {
    private String name;
    private int ID;
    private int age;
    
    //getters and setters
    public String getName(){
        return name;
    }
    public int getID(){
        return ID;
    }
    public int getAge(){
        return age;
    }
    
    public void setName(String n){
        this.name = n;
    }
    public void setID(int i){
        this.ID = i;
    }
    public void setAge(int a){
        this.age = a;
    }
    
    public void displayPets(ArrayList<Pet> pets){
        int smpleID;
        String smpleName;
        int smpleAge;
        //print header
        System.out.print("+----------------------+\n" +
                "| ID | NAME      | AGE |\n" +
                "+----------------------+\n");
        
        //print rows
        for(int i = 0; i < pets.size(); i++){
            smpleID = pets.get(i).getID();
            smpleName = pets.get(i).getName();
            smpleAge = pets.get(i).getAge();
            
            System.out.printf("| %2d | %-9s | %3d |\n", smpleID, smpleName, smpleAge);
        }
        
        //print rows total
        System.out.print("+----------------------+\n");
        System.out.print(pets.size() + " rows in set.\n\n");
    }
    
    public ArrayList<Pet> addMorePets(ArrayList<Pet> pets){
        Scanner scan = new Scanner(System.in);
        int count = 0;
        String newName = "";
        int newAge;
        int newID;
         
        while(!"done".equals(newName)){
            Pet newPet = new Pet();
            System.out.print("add pet (name, age): ");
            newName = scan.next();
            if("done".equals(newName)){
                break;
            }
            newAge = scan.nextInt();
            newID = pets.size() + 1;
            
            if(!"done".equals(newName)){
                newPet.setID(newID);
                newPet.setName(newName);
                newPet.setAge(newAge);
                pets.add(newPet);
                count++;
            }
        }
        System.out.print(count + " pet(s) added\n");
         
        return pets;
    }
}
