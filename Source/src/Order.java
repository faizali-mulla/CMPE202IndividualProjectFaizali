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
        Validate validate = new Validate(inventory, inventoryList, input, inputList);
        boolean isValid = validate.validateOrder();
        System.out.println(isValid);
    }
}