// import java.util.HashMap;

// public class Validate {
//     public boolean validateInput(){

//         ReadDataCSV readDataCSV1 = new ReadDataCSV();
//         ReadDataCSV readDataCSV2 = new ReadDataCSV();
//         DatabaseTableColumnIndex databaseTableColumnIndex = new DatabaseTableColumnIndex();
//         DataSearch dataSearch = new DataSearch();
        
//         HashMap<Integer, String[]> items = new HashMap<Integer, String[]>();
//         HashMap<String, Integer> itemsColumn = new HashMap<String, Integer>();
//         // READ THE INVENTORY DATA CSV
//         items = readDataCSV1.getData("Inventory_Data.csv");
//         // GET THE INVENTORY ITEM TABLE INDEX CORRESPONDING TO INTERNAL ARRAY
//         itemsColumn = databaseTableColumnIndex.getTableColumnIndex("items");

//         HashMap<Integer, String[]> input = new HashMap<Integer, String[]>();
//         HashMap<String, Integer> inputColumn = new HashMap<String, Integer>();
//         // READ THE INPUT ORDER CSV
//         input = readDataCSV2.getData("Input.csv");
//         // GET THE INPUT ORDER TABLE INDEX CORRESPONDING TO INTERNAL ARRAY
//         inputColumn= databaseTableColumnIndex.getTableColumnIndex("input");


//         String[] inputRow;
//         String inputItem;
//         Integer inputQuantity;

//         boolean stockValid = true;

//         for(Integer i=1; ;i++){
//             inputRow = input.get(i);
//             if(inputRow != null){
//                 inputItem = inputRow[inputColumn.get("item")];
//                 inputQuantity = Integer.parseInt(inputRow[inputColumn.get("quantity")]);
//                 if(inputQuantity > Integer.parseInt(dataSearch.searchByUnique("items", items, "item", inputItem)[itemsColumn.get("quantity")])){
//                     stockValid = false;
//                     break;
//                 }
//             }
//             else{
//                 break;
//             }
//         }
//         return stockValid;
//     }
// }