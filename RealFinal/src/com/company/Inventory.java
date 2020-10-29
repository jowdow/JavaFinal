package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Inventory {
    private static ArrayList<ArrayList<String>> inventoryMatrix= new ArrayList<ArrayList<String>>();// static to access throughout class
    private static ArrayList<String> activityLog=new ArrayList<String>();
    private static ArrayList<String> soldLog=new ArrayList<String>();
    private static Date dateOfAction;

    Inventory(){// Default constructor
        ArrayList<String> newProduct= new ArrayList<String>(Arrays.asList("Dog","400.00","Computer","it's a pretty big pupper"));
        inventoryMatrix.add(newProduct);
        newProduct= new ArrayList<String>(Arrays.asList("Blocks","10.00","Computer","Cement with holes"));
        inventoryMatrix.add(newProduct);
        newProduct= new ArrayList<String>(Arrays.asList("Blank Keys","2.50","Computer","Don't use to break into homes"));
        inventoryMatrix.add(newProduct);
    }

    public void addInventory(String product,String price, String description, String seller){
        // You must make the row an ArrayList before appending new row into m
        ArrayList<String> newProduct= new ArrayList<String>(Arrays.asList(product,price,seller,description));
        inventoryMatrix.add(newProduct);
        dateOfAction=new Date();
        activityLog.add( product+" added by "+seller+" with a price of $"+price+" on "+dateOfAction.toString());
    }

    public static void displayActivityLog(){
        for(int index=0;index<activityLog.size();index++){
            System.out.println(activityLog.get(index));
        }
    }

    public static void displaySoldLog(){
        for(int index=0;index<soldLog.size();index++){
            System.out.println(soldLog.get(index));
        }
    }

    public static void displayInventory(){
        System.out.println("Product        Price    Seller         Description");
        for(int index=0;index<inventoryMatrix.size();index++){
            String[] temp= inventoryMatrix.get(index).toArray(new String[0]);
            System.out.printf("%-15s",temp[0]);//Prints product
            System.out.printf("%-9s",temp[1]);//Prints price
            System.out.printf("%-15s",temp[2]);//Prints seller
            System.out.printf("%-30s",temp[3]);//Prints description
            System.out.println();
        }
        System.out.println("");// Making space between menu and inventory display
    }

    public static void displayInventory(int productIndex){
        System.out.println("Product        Price    Seller         Description");
        for(int index=0;index<inventoryMatrix.size();index++){
            if(index==productIndex){
            String[] temp= inventoryMatrix.get(index).toArray(new String[0]);
            System.out.printf("%-15s",temp[0]);//Prints product
            System.out.printf("%-9s",temp[1]);//Prints price
            System.out.printf("%-15s",temp[2]);//Prints seller
            System.out.printf("%-30s",temp[3]);//Prints description
            System.out.println();
            }
        }
    }

    public static void displayInventoryNoHeader(int productIndex){
        for(int index=0;index<inventoryMatrix.size();index++){
            if(index==productIndex){
                String[] temp= inventoryMatrix.get(index).toArray(new String[0]);
                System.out.printf("%-15s",temp[0]);//Prints product
                System.out.printf("%-9s",temp[1]);//Prints price
                System.out.printf("%-15s",temp[2]);//Prints seller
                System.out.printf("%-30s",temp[3]);//Prints description
            }
        }
    }

    public static void displayInventoryWithNumbers(){
        System.out.println("   Product        Price    Seller         Description");
        for(int index=0;index<inventoryMatrix.size();index++){
            String[] temp= inventoryMatrix.get(index).toArray(new String[0]);
            System.out.print("("+(index+1)+")");
            System.out.printf("%-15s",temp[0]);//Prints product
            System.out.printf("%-9s",temp[1]);//Prints price
            System.out.printf("%-15s",temp[2]);//Prints seller
            System.out.printf("%-30s",temp[3]);//Prints description
            System.out.println();
        }
    }

    public static void displaySearch(String product){
        ArrayList<Integer> inventoryIndexes= new ArrayList<>();
        for(int index=0;index<inventoryMatrix.size();index++){
        String[] temp= inventoryMatrix.get(index).toArray(new String[0]);
        for(int secondIndex=0;secondIndex<temp.length;secondIndex++){
            if(temp[secondIndex].equals(product)){
                inventoryIndexes.add(index);
            }
        }
    }
        System.out.println("Product        Price    Seller         Description");
        for(int index=0;index<inventoryIndexes.size();index++) {
            displayInventoryNoHeader(inventoryIndexes.get(index));
            System.out.println(" ");
    }
}

    public static int getSizeOfInventory(){
        return inventoryMatrix.size();
    }

    public static void removeInventory(int productNumber,String name){
        String[] temp= inventoryMatrix.get(productNumber).toArray(new String[0]);
        inventoryMatrix.remove(productNumber);
        dateOfAction=new Date();
        activityLog.add( temp[0]+" with a price of "+temp[1]+" removed by "+name+" removed  on "+dateOfAction.toString());
    }

    public static boolean isInInventory(String product){
        for(int index=0;index<inventoryMatrix.size();index++){
        String[] temp= inventoryMatrix.get(index).toArray(new String[0]);
            for(int secondIndex=0;secondIndex<temp.length;secondIndex++){
                if(temp[secondIndex].equals(product)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void sell(int productNumber,String name){
        String[] temp= inventoryMatrix.get(productNumber).toArray(new String[0]);// Getting array from arraylist to get info for log
        inventoryMatrix.remove(productNumber);
        dateOfAction=new Date();
        activityLog.add(temp[0]+" bought by "+name+" with a price of $"+temp[1]+" on "+dateOfAction.toString());// Logging Actions
        soldLog.add(temp[0]+" bought by "+name+" with a price of $"+temp[1]+" on "+dateOfAction.toString());

    }
}
