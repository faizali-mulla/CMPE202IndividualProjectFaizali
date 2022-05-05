import java.util.ArrayList;
import java.util.HashMap;

class Billing {
    public static void main(String args[]){
        ArrayList<String> dd = new ArrayList<String>();
        dd = TableSearch.getPrimaryArrayList("Inventory.csv", 0);
        Integer index = TableSearch.getIndex(dd, "Chocolates");
        System.out.println(index);
    }
}