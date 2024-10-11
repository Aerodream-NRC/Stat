package aerodream.tstatistic;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import static aerodream.tstatistic.WelcomeController.ReportFilePath;

public class ExcelReader {

    static TreeMap<String, Integer> MapAllActivations = new TreeMap<>();

    static TreeMap<String, Integer> MapActivations = new TreeMap<>();

    static TreeMap<String, Integer> MapDolyameActivations = new TreeMap<>();

    static TreeMap<String, Integer> MapRentTerminalActivations = new TreeMap<>();

    static TreeMap<String, Integer> MapCustomersCreditActivations = new TreeMap<>();

    static TreeMap<String, Integer> MapOtherActivations = new TreeMap<>();

    protected static void excelReader() throws IOException {
        ReportFilePath.replaceAll(" ", "");
        StringBuilder stringBuilder = new StringBuilder(ReportFilePath);
        stringBuilder.delete(0, 6);
        String fileReportPath = stringBuilder.toString();
        Workbook workbook = new XSSFWorkbook(new FileInputStream(fileReportPath));
        Sheet sheet = workbook.getSheetAt(3);
        for (Row row : sheet) {
            Cell cell = row.getCell(0);
            String logins = String.valueOf(cell);
            if(MapAllActivations.containsKey(logins)) {
                MapAllActivations.put(logins, MapAllActivations.get(logins)+1);
            } else {
                MapAllActivations.put(logins, 1);
            }
        }
        MapAllActivations.remove("Оператор");
        loginIterator(MapDolyameActivations);
        loginIterator(MapRentTerminalActivations);
        loginIterator(MapCustomersCreditActivations);
        loginIterator(MapOtherActivations);
        for (Row row : sheet) {
            Cell cell = row.getCell(0);
            Cell cell1 = row.getCell(6);
            String login = String.valueOf(cell);
            String product = String.valueOf(cell1);
            String salesActivations = login + " " + product;
            if (MapActivations.containsKey(salesActivations)){
                MapActivations.put(salesActivations, MapActivations.get(salesActivations)+1);
            } else {
                MapActivations.put(salesActivations, 1);
            }
        }
        MapActivations.remove("Оператор Продукт");
        for(Row row : sheet) {
            Cell cell = row.getCell(0);
            Cell cell1 = row.getCell(6);
            String login = String.valueOf(cell);
            String product = String.valueOf(cell1);
            String rentTerminals = "Аренда ТЭ";
            String customersCredit = "POS";
            String dolyame = "BNPL";
            if (product.equals(dolyame)){
                MapDolyameActivations.put(login, MapActivations.get(login + " " + dolyame));
            } else if (product.equals(rentTerminals)){
                MapRentTerminalActivations.put(login, MapActivations.get(login + " " + rentTerminals));
            } else if (product.equals(customersCredit)){
                MapCustomersCreditActivations.put(login, MapActivations.get(login + " " + customersCredit));
            } else if (MapOtherActivations.containsKey(login)) {
                MapOtherActivations.put(login, MapOtherActivations.get(login)+1);
            } else {
                MapOtherActivations.put(login, 1);
            }
        }
        System.out.println(MapAllActivations);
        System.out.println(MapRentTerminalActivations);
        MapOtherActivations.remove("Оператор");
    }

    public static void loginIterator(TreeMap m) {
        for (Map.Entry<String, Integer> l : MapAllActivations.entrySet()) {
            m.put(l.getKey(), 0);
        }
    }
}