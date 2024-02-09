package bankingapplication;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelExtraction {
    private List<String[]> transactionRecords = new ArrayList<>();

    public void addTransactionRecords(String type, double amount) {
        transactionRecords.add(new String[]{type, String.valueOf(amount)});
    }

    public void exportTransactionsToExcel(String filePath) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Transaction");

        // Create header row
        Row headerRow = sheet.createRow(0);
        String[] columnNames = {"Types", "Amount"};
        for (int i = 0; i < columnNames.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnNames[i]);
        }
        // Populate transactions
        int rowNum = 1;
        for (String[] record : transactionRecords) {
            Row row = sheet.createRow(rowNum++); // increase row num after create row
            for (int i = 0; i < record.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(record[i]);
            }
        }

        File directory = new File(filePath + "\\transactions.xlsx");

        // Write the output to a file
        try (FileOutputStream outputStream = new FileOutputStream(directory)) {
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found or no permission given " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}