package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        User user = new User();
        Scanner input = new Scanner(System.in);
        int selection;
        do {

            menu();
            selection = menuUserValidation();

            System.out.println(" ");
            if (selection == 1) {// Display inventory
                System.out.println("Current Inventory:");
                inventory.displayInventory();
            }// Display inventory
            else if (selection == 2) {// Add inventory
                System.out.println("Enter the name of the product(Example :Toys)");
                System.out.print(":");
                String product = input.nextLine();

                System.out.println("Enter the price of the product(Example :4.50)");
                System.out.print(":");
                String price = input.nextLine();

                System.out.println("Enter a brief description of the product(Example :Brand new):");
                System.out.print(":");
                String description = input.nextLine();

                inventory.addInventory(product,price,description,user.getName());
            }// Add inventory
            else if (selection == 3) {// Delete inventory

                inventory.displayInventoryWithNumbers();
                System.out.println("What you would like to Remove(Example :1)?(Enter 0 to exit menu)");

                selection=inventoryUserValidation(inventory.getSizeOfInventory());
                if (selection != 0) {// if selection is not equal to 0 selected inventory is removed
                    inventory.removeInventory(selection - 1,user.getName());
                }
                selection=-1;// If person enters 0 selection will equal zero and will break do while loop
            }// Delete inventory
            else if (selection == 4) {// buy inventory
                System.out.println("");
                inventory.displayInventoryWithNumbers();
                System.out.println("What you would like to buy?(Example :1)(Enter 0 to exit menu)");

                selection=inventoryUserValidation(inventory.getSizeOfInventory());
                if (selection != 0) {// if selection is not equal to 0 selected inventory is sold
                    inventory.sell(selection - 1, user.getName());
                }
                selection=-1;// If  will break do while loop so selection is being changed to avoid that
            }// buy inventory
            else if (selection == 5) {// Search inventory
                String stringInput;
                boolean inInventory;

                System.out.println("What would you like to search by?");
                System.out.println("(1)Name");
                System.out.println("(2)Price");
                System.out.println("(3)Seller");
                System.out.println("Please enter your selection(Example :1)");

                selection=menuUserValidation();

                switch(selection){
                    case 1:
                        System.out.println("What is the name of the product(Example :Shampoo)?");
                        break;
                    case 2:
                        System.out.println("What is the price of the product(Example :4.50)?");
                        break;
                    case 3:
                        System.out.println("What is the name of the seller(Example :John)?");
                        break;
                    default:
                        System.out.println("Number is not on menu!!!");
                        break;
                }

                if(selection>0&&selection<=3){
                    System.out.print(":");
                    stringInput=input.nextLine();
                    System.out.println("");

                    inInventory=inventory.isInInventory(stringInput);

                    if(inInventory){
                        inventory.displaySearch(stringInput);
                    }
                    else{
                        System.out.println("Sorry "+stringInput+" is not in the inventory");
                        System.out.println(" ");
                    }
                }
            }// Search inventory
            else if (selection == 6) {
                System.out.println("                        SOLD LOG");
                inventory.displaySoldLog();
            }
            else if (selection == 7) {
                System.out.println("                       ACTIVITY LOG");
                inventory.displayActivityLog();
            }
            else if (selection == 0) {
                System.out.println("Thank you for shopping at THE MARKET PLACE");
                break;
            }
            else {
                System.out.println("Invalid input please enter in a valid number");
            }
        } while (selection != 0);// while the selection is not 0 the program loops


    }

    public static void menu() {
        System.out.println(" ");
        System.out.println("Welcome to the Marketplace!!!");
        System.out.println("(1)Display Current Inventory");
        System.out.println("(2)Add Inventory");
        System.out.println("(3)Delete Inventory");
        System.out.println("(4)Purchase From Inventory");
        System.out.println("(5)Search Inventory");
        System.out.println("(6)Display Sold Inventory");
        System.out.println("(7)Display Activity");
        System.out.println("(0)Exit");
        System.out.println("Please Enter Your Selection (Example :1)");
    }

    public static int inventoryUserValidation(int sizeOfInventory){
        Scanner input= new Scanner(System.in);
        int selection=0;
        try{
            System.out.print(":");
            selection = input.nextInt();
            if (selection>sizeOfInventory){// If number is too large recursion will occur
                System.out.println("Please enter a real number that is on the menu");
                inventoryUserValidation(sizeOfInventory);
            }
            return selection;
        }
        catch(InputMismatchException e){// If string or char is entered exception will occur
            System.out.println("Please enter a real number that is on the menu");
            inventoryUserValidation(sizeOfInventory);
            return 0;
        }
    }

    public static int menuUserValidation(){
        Scanner input= new Scanner(System.in);
        int selection=0;
        try{
            System.out.print(":");
            selection = input.nextInt();
            return selection;
        }
        catch(InputMismatchException e){// If int is not entered exception will occur
            System.out.println("Please enter a real number that is on the menu");
            menuUserValidation();
            return -1;
        }
    }
}