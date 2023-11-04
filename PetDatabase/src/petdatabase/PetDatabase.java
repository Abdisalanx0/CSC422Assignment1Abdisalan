/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package petdatabase;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Abdisalan
 */

public class PetDatabase {
public static ArrayList<pet> petsArray = new ArrayList<pet>();
public static Scanner scanner = new Scanner(System.in);
public static int rowCounter = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       menu();
    }
    public static void menu(){
        while(true){
        System.out.println("Pet Database Program");
        System.out.println("what would you like to do?");
        System.out.println("1) View all pets");
        System.out.println("2) Add more pets");
        System.out.println("3) Update an existing pet");
        System.out.println("4) Remove an existing pet");
        System.out.println("5) Search pets by name");
        System.out.println("6) Search pets by age");
        System.out.println ("7) Exit program");
        System.out.println(" Your choice:");
        int menuChoice =  scanner.nextInt();    
        System.out.println(menuChoice);
        switch(menuChoice){
            
            case 1 : viewAllPets();
                        break;
            case 2 : addPet();
                        break;
            case 3 : updatePet();
                        break;
            case 4 : deletePet();
                        break;
            case 5 : searchPetsByName();
                        break;
            case 6 :searchPetsByAge();
                         break;
            case 7: System.out.println("Thank you for using pet database");   
                break;
            
            
        }
    }
    }
    public static void viewAllPets(){
    printTableHeader();
    printTableRow();
    printTableFooter();
    }//end of viewAllPets
    
    public static void addPet(){
      String name; int age;
     System.out.println("please enter the pet Information below");
    while (true) {
            System.out.print("Enter pet name and age ('Name Age'): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            
            if (parts.length != 2) {//check if they enter more or less than 2 inputs!
                System.out.println("Invalid input. Please enter name and age separated by a space.");
                continue;
            }

             name = parts[0];
        

            try {///checks if they enter a number
                age = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid age. Please enter a valid integer.");
                continue;
            }

            pet newPet = new pet(name, age);
            petsArray.add(newPet);
            System.out.println("Pet added: " + newPet.getPetName());
            rowCounter++;
        }

        
   
    }//end of addPet
    
    public static void deletePet(){}//end of deletePet
    
    public static void updatePet(){}//end of updatePet
    
    public static void searchPetsByName(){}//end of search pets by name 
            
    public static void searchPetsByAge() {}//end of search pets by age  
    
    
    public static void printTableHeader(){
        System.out.println("+-------------------+");
        System.out.println("|ID| Name       |Age|");
        System.out.println("+-------------------+");
}//end of print Table Header
     public static void printTableRow(){
         int counter = 0;
          for (pet pet : petsArray) {
            System.out.println("| "+counter+++"|  "+pet.getPetName()+"\t"+"|"+pet.getAge()+"  |");}        }
    
   
       
    
     public static void printTableFooter(){
        System.out.println("+-------------------+");
        System.out.println(rowCounter+"rows in set");}//end of printTableRow
    
    
    
    }
    

    
    
    


