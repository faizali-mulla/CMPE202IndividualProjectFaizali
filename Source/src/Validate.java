import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
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
        String validationCategoryMsg = "";

        Integer inventoryIndex;
        Integer inputIndex;

        ArrayList<String> categoryList = new ArrayList<String>();

        //CHECK IF ITEM AVAILABLE IN INVENTORY
        for (String element : inputList) {
            if(inventoryList.contains(element) == false){
                validationAvailabilityMessage = validationAvailabilityMessage + "|" + "Not contained: " + element;
                validFlag = false;
            }
        }

        
        //CHECK FOR THE QUANTITY AVAILABLE AND ALSO MAKE CATEGORY LIST
        for(Integer i=1; i<=input.size(); i++){
            if(inventoryList.contains(input.get(i)[0]) == true){
                inventoryIndex = TableSearch.getIndex(inventoryList, input.get(i)[0]);
                categoryList.add(inventory.get(inventoryIndex)[1]);
                if(Integer.parseInt(input.get(i)[1]) > Integer.parseInt(inventory.get(inventoryIndex)[2])){
                    validationQuantityMsg = validationQuantityMsg + "|" + "Quantity Issue:" + input.get(i)[0];
                    validFlag = false;
                }
            }
        }
        
        //CHECK FOR THE CATEGORY CAP
        Integer essentialsFrequency = Collections.frequency(categoryList, "Essentials");
        if(essentialsFrequency > CategoryConfig.EssentialsCap){
            System.out.println("category Issue");
        }
        Integer luxuryFrequency = Collections.frequency(categoryList, "Luxury");
        if(luxuryFrequency > CategoryConfig.LuxuryCap){
            System.out.println("category Issue");
        }
        Integer miscFrequency = Collections.frequency(categoryList, "Misc");
        if(miscFrequency > CategoryConfig.MiscCap){
            System.out.println("category Issue");
        }
        System.out.println(validationAvailabilityMessage);
        System.out.println(validationQuantityMsg);

        return validFlag;
    
}
}