import java.util.HashMap;

public class DatabaseTableColumnIndex {
    public HashMap<String, Integer> getTableColumnIndex(String tableName){
        HashMap<String, Integer> ItemsTableColumn = new HashMap<String, Integer>();
        HashMap <String, Integer> CardsTableColumn = new HashMap<String, Integer>();
        HashMap<String, Integer> InputDataColumn = new HashMap<String, Integer>();   

        ItemsTableColumn.put("item", 0);
        ItemsTableColumn.put("category", 1);
        ItemsTableColumn.put("quantity", 2);
        ItemsTableColumn.put("price", 3);

        CardsTableColumn.put("cardNumber", 0);

        InputDataColumn.put("item", 0);
        InputDataColumn.put("quantity", 1);
        InputDataColumn.put("cardNumber", 2);


        //------------------//

        HashMap<String, HashMap<String, Integer>> mainMap = new HashMap<String, HashMap<String, Integer>>();
        mainMap.put("items", ItemsTableColumn);
        mainMap.put("cards", CardsTableColumn);
        mainMap.put("input", InputDataColumn);

        //------------------//


        return mainMap.get(tableName);
    }
}
