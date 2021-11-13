/*
This class is for creating pets to be stored in the data base
 */
package petdatabase;

import java.io.FileWriter;
import java.io.IOException;
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
        
        if(pets.size() == 5){
            System.out.print("\nDatabase is full. No more pets can be added.\n");
        }
        
        while(pets.size()< 5){
            while(!"done".equals(newName)){
                Pet newPet = new Pet();
                System.out.print("add pet (name, age): ");
                newName = scan.nextLine();
                String[] checkName = newName.split(" ");
                while(checkName.length > 2){
                    System.out.print("Please enter a name and and an age in the correct fashion: ");
                    newName = scan.nextLine();
                    checkName = newName.split(" ");
                }
                if("done".equals(newName)){
                    break;
                }
                newName = checkName[0];
                newAge = Integer.parseInt(checkName[1]);
                while(newAge > 20){
                    System.out.print("The age you have entered is invalid. Please enter a number between 1 and 20: ");
                    newAge = scan.nextInt();
                }
                newID = pets.size() + 1;
            
                if(!"done".equals(newName)){
                    newPet.setID(newID);
                    newPet.setName(newName);
                    newPet.setAge(newAge);
                    pets.add(newPet);
                    count++;
                }
                if(pets.size() == 5){
                    System.out.print("\nDatabase is full. No more pets can be added.\n");
                    break;
                }
            }
            System.out.print(count + " pet(s) added\n");
        } 
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
    
    public Pet getDatabasePet(String p){
        ArrayList<Pet> pets = new ArrayList<>();
        Pet newPet = new Pet();
        
        //put pet data into an object
        String[] newPetData = p.split(" ");
        newPet.setName(newPetData[0]);
        newPet.setAge(Integer.parseInt(newPetData[1]));
        
        return newPet;
    }
    
    public void savePetData(ArrayList<Pet> pets){
        try {
            FileWriter writer = new FileWriter("databaseOfPets.txt");
            for(int i = 0; i < pets.size(); i++){
                writer.write(pets.get(i).getName() + " " + pets.get(i).getAge() + "\n");
            }
            writer.close();
        }
        catch (IOException e){
            System.out.print("\nAn error occured\n");
        }
        
    }
}

