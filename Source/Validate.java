import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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

        boolean validFlag = true;
        String validationAvailabilityMessage = "";
        String validationQuantityMsg = "";
        String validationCategoryMsg = "";
        String validationFullMsg = "";

        Integer inventoryIndex;

        ArrayList<String> categoryList = new ArrayList<String>();

        //CHECK IF ITEM AVAILABLE IN INVENTORY
        for (String element : inputList) {
            if(inventoryList.contains(element) == false){
                validationAvailabilityMessage = validationAvailabilityMessage + "\n" + element;
                validFlag = false;
            }
        }

        
        //CHECK FOR THE QUANTITY AVAILABLE AND ALSO MAKE CATEGORY LIST
        for(Integer i=1; i<=input.size(); i++){
            if(inventoryList.contains(input.get(i)[0]) == true){
                inventoryIndex = TableSearch.getIndex(inventoryList, input.get(i)[0]);
                categoryList.add(inventory.get(inventoryIndex)[1]);
                if(Integer.parseInt(input.get(i)[1]) > Integer.parseInt(inventory.get(inventoryIndex)[2])){
                    validationQuantityMsg = validationQuantityMsg + "\n" + input.get(i)[0] + " : " + "Only " + inventory.get(inventoryIndex)[2] + " available";
                    validFlag = false;
                }
            }
        }
        
        //CHECK FOR THE CATEGORY CAP
        Integer essentialsFrequency = Collections.frequency(categoryList, "Essentials");
        if(essentialsFrequency > CategoryConfig.EssentialsCap){
            validFlag = false;
            validationCategoryMsg = validationCategoryMsg + "\n" + "Please reduce the type of items in the Essentials category.  Limit for Essentials category is " + CategoryConfig.EssentialsCap;
        }
        Integer luxuryFrequency = Collections.frequency(categoryList, "Luxury");
        if(luxuryFrequency > CategoryConfig.LuxuryCap){
            validFlag = false;
            validationCategoryMsg = validationCategoryMsg + "\n" + "Please reduce the type of items in the Luxury category.  Limit for Luxury category is " + CategoryConfig.LuxuryCap;
        }
        Integer miscFrequency = Collections.frequency(categoryList, "Misc");
        if(miscFrequency > CategoryConfig.MiscCap){
            validFlag = false;
            validationCategoryMsg = validationCategoryMsg + "\n" + "Please reduce the type of items in the Misc category.  Limit for Misc category is " + CategoryConfig.MiscCap;
        }
        

        if(validationAvailabilityMessage != ""){
            validationAvailabilityMessage = "Some of the item(s) you ordered are not available.  Please make the necessary changes to the order.  Items not available are -" + validationAvailabilityMessage;
        }

        if(validationQuantityMsg != ""){
            validationQuantityMsg = "We can not fulfill your order due to lack of quantity of certain items in the stock.  Please reduce the quantities in your order to proceed with your order.  These items are -" + validationQuantityMsg;
        }

        if(validationCategoryMsg != ""){
            validationCategoryMsg = "The maximum limit of certain categories of items has been exceeded." + validationCategoryMsg;
        }
        
        if(validFlag == false){
            validationFullMsg = "Your order has some problems.  Please read the below instructions and make necessary changes to the order by changing data in the Input.csv file." + validationAvailabilityMessage + "\n\n" + validationQuantityMsg + "\n\n" + validationCategoryMsg;
        }
        else{
            validationFullMsg = "Everything is fine.  No errors.";
        }

        //CREATE AND WRITE TO A FILE
        File validationMsgFile = new File(FilesConfig.ValidationMessageFile);
        try{
            validationMsgFile.createNewFile();
        }
        catch(IOException e){
            
        }

        try{
            FileWriter fileWriter = new FileWriter(FilesConfig.ValidationMessageFile);
            fileWriter.write(validationFullMsg);
            fileWriter.close();
        }
        catch(IOException e){
            System.out.println("Some error occured while writing the notification file.");
        }

        return validFlag;
    
    }
}