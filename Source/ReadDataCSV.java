import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadDataCSV {
    GeneralFunctions gf = new GeneralFunctions();
    HashMap<Integer, String[]> dataHashMap = new HashMap<Integer, String[]>();
    public HashMap<Integer, String[]> getData(String filePath){
        
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String row = "";
            bufferedReader.readLine();
            for(Integer i=1; ;i++){
                row = bufferedReader.readLine();
                if (row != null)
                {
                    String[] rowArr = row.split(",");
                    dataHashMap.put(i, rowArr);
                }
                else{
                    break;
                }
            }
            return dataHashMap;
        } catch (IOException e) {
            System.out.println("Error:  Could not read file.");
            return null;
        }
    }

    
}
