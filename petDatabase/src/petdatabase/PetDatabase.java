/*
This is an application for making and editing a pet database
 */
package petdatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nolan Harre
 */
public class PetDatabase {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Pet> pets = new ArrayList<>();
        ArrayList<Pet> results = new ArrayList<>();
        int identifier;
        Pet pet = new Pet();
        String choice = "0";
        System.out.print("Pet Database Program.\n\n");
        
        //get data from file
        try{
            File petDatabase = new File("databaseOfPets.txt");
            Scanner reader = new Scanner(petDatabase);
            while(reader.hasNextLine()){
                Pet petData = new Pet();
                String databasePet = reader.nextLine();
                
                //put data into arraylist
                petData = pet.getDatabasePet(databasePet);
                petData.setID(pets.size() + 1);
                pets.add(petData);
            }
        }
        catch (FileNotFoundException e){
            System.out.print("\nCould not find file\n");
        }
        
        
        while(!"7".equals(choice)){
            System.out.print("\nWhat would you like to do?\n");
            printOptions();
            choice = scan.next();
            
            switch (choice) {
                //view all pets
                case "1":
                    pet.displayPets(pets);
                    break;
                    
                //add more pets    
                case "2":
                    pet.addMorePets(pets);
                    break;
                    
                //update a pet
                case "3":
                    pet.displayPets(pets);
                    System.out.print("Enter the ID of the pet you would like to update: ");
                    identifier = scan.nextInt();
                    pet.updatePet(pets, identifier);
                    break;
                    
                //remove pet
                case "4":
                    pet.displayPets(pets);
                    System.out.print("Enter the ID to remove: ");
                    identifier = scan.nextInt();
                    pet.removePet(pets, identifier);
                    break;
                    
                //search by name
                case "5":
                    results = pet.searchPetsName(pets);
                    
                    pet.displayPets(results);
                    break;
                    
                //search by age    
                case "6":
                    results = pet.searchPetAge(pets);
                    
                    pet.displayPets(results);
                    break;
                    
                //exit  
                case "7":
                    System.out.print("Goodbye!\n");
                    pet.savePetData(pets);
                    break;
                    
                default:
                    System.out.print("Please pick a number between 1 and 7\n\n");
                    break;
            }
        }
    }
    
    public static void printOptions(){
        System.out.print("1) View all pets\n"
                +"2) Add more pets\n"
                + "3) Update an existing pet\n"
                + "4) Remove and existing pet\n"
                + "5) Search pets by name\n"
                + "6) Search pets by age\n"
                + "7) Exit the program\n"
                + "Your choice: "
                );
    }
    
}
