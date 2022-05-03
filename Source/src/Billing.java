import java.util.HashMap;

class Billing {
    public static void main(String args[]){
        GeneralFunctions gf = new GeneralFunctions();

        ReadDataCSV readDataCSV = new ReadDataCSV();
        DatabaseTableColumnIndex databaseTableColumnIndex = new DatabaseTableColumnIndex();
        
        HashMap<Integer, String[]> items = new HashMap<Integer, String[]>();
        HashMap<String, Integer> itemsColumn = new HashMap<String, Integer>();
        // READ THE INVENTORY DATA CSV
        items = readDataCSV.getData("Inventory_Data.csv");
        // GET THE INVENTORY ITEM TABLE INDEX CORRESPONDING TO INTERNAL ARRAY
        itemsColumn = databaseTableColumnIndex.getItemsTableColumnIndex();


        // HashMap<Integer, String[]> cards = new HashMap<Integer, String[]>();
        // HashMap<String, Integer> cardsColumn = new HashMap<String, Integer>();
        // // READ THE CARDS CSV
        // cards = readDataCSV.getData("Cards.csv");
        // // GET THE CARDS TABLE INDEX CORRESPONDING TO INTERNAL ARRAY
        // cardsColumn = databaseTableColumnIndex.getCardsTableColumnIndex();
    }
}