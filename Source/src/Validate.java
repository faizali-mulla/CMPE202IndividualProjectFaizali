import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.print.DocFlavor.STRING;

public class Validate {

    HashMap <Integer, String[]> inventory;
    ArrayList<String> inventoryList;
    HashMap <Integer, String[]> input;
    ArrayList<String> inputList;

    public Validate(HashMap <Integer, String[]> inventory, ArrayList<String> inventoryList, HashMap <Integer, String[]> input, ArrayList<String> inputList){
        this.inventory = inventory;
        this.inventoryList = inventoryList;
        this.input = input;
        this.inputList = inputList;
    }

    public boolean validateOrder(){

        // //ttttttttttttttttttttttteeeeeeeeeeeeeesssssssssssssttttttttttttt

        // inventory = TableSearch.getTable(FilesConfig.InventoryFile);
        // input = TableSearch.getTable(FilesConfig.InputFile);

        // //tttttttttttttttttttteeeeeeeeeeeeesssssssssssssssstttttttttt

        boolean validFlag = true;
        String validationAvailabilityMessage = "";
        String validationQuantityMsg = "";

        Integer inventoryIndex;
        Integer inputIndex;

        for (String element : inputList) {
            //CHECK IF ITEM AVAILABLE IN INVENTORY
            if(inventoryList.contains(element) == false){
                validationAvailabilityMessage = validationAvailabilityMessage + "|" + "Not contained: " + element;
                validFlag = false;
            }
        }

        

        for(Integer i=1; i<=input.size(); i++){

            if(inventoryList.contains(input.get(i)[0]) == true){
                inventoryIndex = TableSearch.getIndex(inventoryList, input.get(i)[0]);
            
                if(Integer.parseInt(input.get(i)[1]) > Integer.parseInt(inventory.get(inventoryIndex)[2])){
                validationQuantityMsg = validationQuantityMsg + "|" + "Quantity Issue:" + input.get(i)[0];
                validFlag = false;
            }

            }
            // System.out.println(inventory.get(inventoryIndex)[2]);
        }
        

        System.out.println(validationAvailabilityMessage);
        System.out.println(validationQuantityMsg);

        return validFlag;
    
}
}