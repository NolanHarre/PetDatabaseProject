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
    
    public ArrayList<Pet> searchPetsName(ArrayList<Pet> pets){
        Scanner scan = new Scanner(System.in);
        ArrayList<Pet> results = new ArrayList<>();
        String tempName;
        
        //get search name
        System.out.print("Enter a name to search: ");
        String searchName = scan.next();
        
        //search through database
        for(int i = 0; i < pets.size(); i++){
            tempName = pets.get(i).getName();
            
            if(tempName.equalsIgnoreCase(searchName)){
                results.add(pets.get(i));
            }
        }
        //output results
        return results;
    }
    
    public ArrayList<Pet> searchPetAge(ArrayList<Pet> pets){
        Scanner scan = new Scanner(System.in);
        ArrayList<Pet> results = new ArrayList<>();
        int tempAge;
        
        //get search name
        System.out.print("Enter an age to search: ");
        int searchAge = scan.nextInt();
        
        //search through database
        for(int i = 0; i < pets.size(); i++){
            tempAge = pets.get(i).getAge();
            
            if(tempAge == searchAge){
                results.add(pets.get(i));
            }
        }
        //output results
        return results;
    }
    
    public ArrayList<Pet> removePet(ArrayList<Pet> pets, int p){
        //remove pet
        Pet pet = new Pet();
        pet = pets.get(p - 1);
        pets.remove(pet);
        
        //print removal message
        System.out.print(pet.getName() + " " + pet.getAge() + " is removed.\n\n");
        
        //reset ids
        for(int i = 0; i < pets.size(); i++){
            pet = pets.get(i);
            pet.setID(i + 1);
        }
        
        return pets;
    }
    
    public ArrayList<Pet> updatePet(ArrayList<Pet> pets, int p){
        Scanner scan = new Scanner(System.in);
        Pet pet = pets.get(p-1);
        String oldName = pet.getName();
        int oldAge = pet.getAge();
        System.out.print("\nEnter a new name and a new age: ");
        pet.setName(scan.next());
        pet.setAge(scan.nextInt());
        
        System.out.print(oldName + " " + oldAge + " has been changed to " + pet.getName() + " " + pet.getAge() + "\n\n");
        
        return pets;
    }
}
