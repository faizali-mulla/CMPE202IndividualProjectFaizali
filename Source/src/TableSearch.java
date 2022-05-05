import java.util.ArrayList;
import java.util.HashMap;

public class TableSearch {
    public static HashMap<Integer, String[]> getTable(String filePath){
        ReadDataCSV readDataCSV1 = new ReadDataCSV();
        HashMap<Integer, String[]> table = new HashMap<Integer, String[]>();
        table = readDataCSV1.getData(filePath);
        return table;
    }

    public static ArrayList<String> getPrimaryArrayList(String fileName, Integer ColumnIndex){
        HashMap<Integer, String[]> table = getTable(fileName);
        ArrayList<String> primaryArrayList = new ArrayList<String>();
        for(Integer i=1; i<=table.size(); i++){
            primaryArrayList.add(table.get(i)[ColumnIndex]);
        }
        return primaryArrayList;
    }

    public static Integer getIndex(ArrayList<String> list, String searchValue){
        if(list.contains(searchValue) == true){
            return list.indexOf(searchValue) + 1;
        }
        else{
            return null;
        }
    }
}