import java.util.HashMap;

public class DatabaseTableColumnIndex {
    HashMap<String, Integer> ItemsTableColumn = new HashMap<String, Integer>();
    HashMap <String, Integer> CardsTableColumn = new HashMap<String, Integer>();
    public HashMap<String, Integer> getItemsTableColumnIndex(){
        ItemsTableColumn.put("item", 0);
        ItemsTableColumn.put("category", 1);
        ItemsTableColumn.put("quantity", 2);
        ItemsTableColumn.put("price", 3);
        return ItemsTableColumn;
    }

    public HashMap<String, Integer> getCardsTableColumnIndex(){
        CardsTableColumn.put("cardNumber", 0);
        return CardsTableColumn;
    }
}
