import java.util.ArrayList;
import java.util.HashMap;

class Billing {
    public static void main(String args[]){
        
        HashMap <Integer, String[]> inventory = new HashMap<Integer, String[]>();
        inventory = TableSearch.getTable(FilesConfig.InventoryFile);

        ArrayList<String> inventoryList = new ArrayList<String>();
        inventoryList = TableSearch.getPrimaryArrayList(FilesConfig.InventoryFile, 0);

        HashMap <Integer, String[]> input = new HashMap<Integer, String[]>();
        input = TableSearch.getTable(FilesConfig.InputFile);

        ArrayList<String> inputList = new ArrayList<String>();
        inputList = TableSearch.getPrimaryArrayList(FilesConfig.InputFile, 0);


        Order order = new Order(inventory, inventoryList, input, inputList);
        order.placeOrder();

    }
}