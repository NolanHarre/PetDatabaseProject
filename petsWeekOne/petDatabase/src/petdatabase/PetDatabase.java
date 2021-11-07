/*
This is an application for making and editing a pet database
 */
package petdatabase;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nolan Harre
 */
public class PetDatabase {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Pet> pets = new ArrayList<>();
        Pet pet = new Pet();
        String choice = "0";
        System.out.print("Pet Database Program.\n\n");
        
        //Pet smplePet = new Pet();
        //smplePet.setID(1);
        //smplePet.setName("Fido");
        //smplePet.setAge(5);
        //pets.add(smplePet);
        
        while(!"7".equals(choice)){
            System.out.print("What would you like to do?\n");
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
                    
                    break;
                    
                //remove pet
                case "4":
                    
                    break;
                    
                //search by name
                case "5":
                    
                    break;
                    
                //search by age    
                case "6":
                    
                    break;
                    
                //exit  
                case "7":
                    System.out.print("Goodbye!\n");
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
