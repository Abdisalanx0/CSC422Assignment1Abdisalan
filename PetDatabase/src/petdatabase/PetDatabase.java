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

    public static ArrayList<Pet> petsArray = new ArrayList<Pet>();
    public static Scanner scanner = new Scanner(System.in);
    public static int rowCounter = 0;
    public static int idCounter = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        while (true) {
            System.out.println("Pet Database Program");
            System.out.println("what would you like to do?");
            System.out.println("1) View all pets");
            System.out.println("2) Add more pets");
            System.out.println("3) Update an existing pet");
            System.out.println("4) Remove an existing pet");
            System.out.println("5) Search pets by name");
            System.out.println("6) Search pets by age");
            System.out.println("7) Exit program");
            System.out.println(" Your choice:");
            int menuChoice = scanner.nextInt();
            switch (menuChoice) {

                case 1:
                    viewAllPets();
                    break;
                case 2:
                    addPet();
                    break;
                case 3:
                    updatePet();
                    break;
                case 4:
                    deletePet();
                    break;
                case 5:
                    searchPetsByName();
                    break;
                case 6:
                    searchPetsByAge();
                    break;
                case 7:
                    System.out.println("Thank you for using pet database");
                    break;

            }
        }
    }

    public static void viewAllPets() {
        printTableHeader();
        printTableRow();
        printTableFooter();
    }//end of viewAllPets

    public static void addPet() {
        String name;
        int age;
        System.out.println("please enter the pet Information below");
        scanner.nextLine();
        while (true) {
            System.out.print("Enter pet name and age ('Name Age'): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
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

            Pet newPet = new Pet(idCounter++, name, age);
            petsArray.add(newPet);
            System.out.println("Pet added: " + newPet.getPetName());
            rowCounter++;
        }

    }//end of addPet

    public static void deletePet() {
        System.out.print("Enter the ID of the pet you want to delete(ex:1): ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < petsArray.size(); i++) {
            Pet pet = petsArray.get(i);
            if (pet.getID() == idToDelete) {
                pet.setID(i - 1);
                petsArray.remove(i);

                System.out.println("Pet with ID " + idToDelete + " has been deleted.");

                rowCounter--;
                return;

            }

        }

        System.out.println("Pet with ID " + idToDelete + " not found in the list.");
    }//end of deletePet

    public static void updatePet() {
        String newName;
        int newAge;
        System.out.print("Enter the ID of the pet you want to Update(ex:1): ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter a new name and age for your pet!");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        if (parts.length != 2) {//check if they enter more or less than 2 inputs!
            System.out.println("Invalid input. Please enter name and age separated by a space.");

        }

        newName = parts[0];
        newAge = Integer.parseInt(parts[1]);

        for (int i = 0; i < petsArray.size(); i++) {
            Pet pet = petsArray.get(i);
            if (pet.getID() == idToUpdate) {
                pet.setPetName(newName);
                pet.setAge(newAge);
                //System.out.println("Pet with ID " + idToDelete + " has been deleted.");

                return;

            }

        }

    }//end of updatePet

    public static void searchPetsByName() {
        Scanner scanner2 = new Scanner(System.in);
        int newRowCounter = 0;
        System.out.print("Enter the name of the pet you want to find (e.g., roxxy): ");
        String nameToSearch = scanner2.nextLine();
        System.out.println("Pets with name '" + nameToSearch + "':");
        printTableHeader();
        for (Pet pet : petsArray) {
            if (pet.getPetName().equalsIgnoreCase(nameToSearch)) {

                System.out.println("| " + pet.getID() + "|  " + pet.getPetName() + "\t" + "|" + pet.getAge() + " |");
                newRowCounter++;
            }
        }
        rowCounter = newRowCounter;
        printTableFooter();
        rowCounter = petsArray.size();
        System.out.println("No pets found with name '" + nameToSearch + "'.");

    }//end of search pets by name 

    public static void searchPetsByAge() {
        Scanner scanner2 = new Scanner(System.in);
        int newRowCounter = 0;
        System.out.print("Enter the Age of the pet you want to find (e.g.,5): ");
        int ageToSearch = scanner2.nextInt();
        System.out.println("Pets with the age of '" + ageToSearch + "':");
        printTableHeader();
        for (Pet pet : petsArray) {
            if (pet.getAge() == ageToSearch) {

                System.out.println("| " + pet.getID() + "|  " + pet.getPetName() + "\t" + "|" + pet.getAge() + " |");
                newRowCounter++;
            }
        }
        rowCounter = newRowCounter;
        printTableFooter();
        rowCounter = petsArray.size();
        System.out.println("No pets found with the age of '" + ageToSearch + "'.");

    }//end of search pets by age  

    public static void printTableHeader() {
        System.out.println("+-------------------+");
        System.out.println("|ID| Name       |Age|");
        System.out.println("+-------------------+");
    }//end of print Table Header

    public static void printTableRow() {
        for (Pet pet : petsArray) {
            System.out.println("| " + pet.getID() + "|  " + pet.getPetName() + "\t" + "|  " + pet.getAge() + "|");
        }
    }

    public static void printTableFooter() {
        System.out.println("+-------------------+");
        System.out.println(rowCounter + " rows in set");
    }//end of printTableRow

}
