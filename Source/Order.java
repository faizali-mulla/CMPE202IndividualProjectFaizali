import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Order{

    HashMap <Integer, String[]> inventory;
    ArrayList<String> inventoryList;
    HashMap <Integer, String[]> input;
    ArrayList<String> inputList;

    public Order(HashMap <Integer, String[]> inventory, ArrayList<String> inventoryList, HashMap <Integer, String[]> input, ArrayList<String> inputList){
        this.inventory = inventory;
        this.inventoryList = inventoryList;
        this.input = input;
        this.inputList = inputList;
    }
    
    public void placeOrder(){
        ArrayList<String> cardsList = new ArrayList<String>();
        cardsList = TableSearch.getPrimaryArrayList(FilesConfig.CardsFile, 0);
        if(cardsList.contains(input.get(1)[2]) == false){
            try{
                FileWriter fileWriter = new FileWriter(FilesConfig.CardsFile, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(input.get(1)[2]);
                bufferedWriter.close();
            }
            catch(IOException e){}
        }
        Validate validate = new Validate(inventory, inventoryList, input, inputList);
        boolean isValid = validate.validateOrder();
        if(isValid == true){
            Double totalPrice = 0.0;
            String CSVOutput = "";

            Integer inventoryIndex;
            CSVOutput = "Item, Quantity, Price";
            for(Integer i=1; i<=input.size(); i++){
                
                    inventoryIndex = TableSearch.getIndex(inventoryList, input.get(i)[0]);
                    totalPrice = totalPrice + Double.parseDouble(input.get(i)[1]) * Double.parseDouble(inventory.get(inventoryIndex)[3]);
                    CSVOutput = CSVOutput + "\n" + inventory.get(inventoryIndex)[0] + "," + input.get(i)[1] + "," + inventory.get(inventoryIndex)[3];
            }
            CSVOutput = CSVOutput + "\nTotal Price," + totalPrice.toString();

            File outputFile = new File(FilesConfig.OutputFile);
            try{
                outputFile.createNewFile();
            }
            catch(IOException e){
                
            }

            try{
                FileWriter fileWriter = new FileWriter(FilesConfig.OutputFile);
                fileWriter.write(CSVOutput);
                fileWriter.close();
            }
            catch(IOException e){
                System.out.println("Some error occured while writing the output file.");
            }
        }
        else{
            File file = new File(FilesConfig.OutputFile);
            file.delete();
        }
    }
}