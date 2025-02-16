package com.qa.main.io;

import java.io.*;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

    private Workbook workbook;
    private final FileInputStream fileInputStream;

    public ReadData(String fileName) throws IOException {
        // Create a File instance to locate the xlsx file
        File file = new File(fileName);
        boolean isFile = file.isFile() ? true : false;
        if (!isFile) {
            throw new FileNotFoundException("File not found: " + fileName);
        } else {
            // Create an InputStream to read the xlsx file
            fileInputStream = new FileInputStream(file);

            // Create a Workbook instance and read the xlsx file
            workbook = new XSSFWorkbook(fileInputStream); // data.xlsx file
        }
    }

    public void readData(String sheetName) throws IOException {
        try {
            // Get the sheet by its name or index
            Sheet sheet = workbook.getSheet(sheetName);  // the sheet

            // Get row from 0 (0-based index)
            Row row = sheet.getRow(1); // the row
            Cell cell = row.getCell(1); // Cell is the column

            String cellValue = cell.getStringCellValue();
            System.out.println("Cell value: " + cellValue);
            System.out.println("Sheet: " + cell.getSheet().getSheetName());
            System.out.println("Total Rows index : " + sheet.getLastRowNum());

            System.out.println("Total Columns index : " + sheet.getRow(0).getLastCellNum());

            int rowInIndex = sheet.getLastRowNum();

            String store = "";
            for (int i = 0; i <= rowInIndex; i++) {
                int column = sheet.getRow(i).getLastCellNum();
                for (int j = i; j < column; j++) {
                    String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
                    String rowValue = "";
                    switch (stringCellValue) {
                        case "id":
                            System.out.println("Column Name: " + stringCellValue);
                            rowValue = sheet.getRow(i + 1).getCell(j).getStringCellValue();
                            System.out.println("Value: " + rowValue);
                            break;
                        case "name":
                            System.out.println("Column Name: " + stringCellValue);
                            rowValue = sheet.getRow(i + 1).getCell(j).getStringCellValue();
                            System.out.println("Row Value: " + rowValue);
                            break;
                        case "age":
                            System.out.println("Column Name: " + stringCellValue);
                            rowValue = sheet.getRow(i + 1).getCell(j).getStringCellValue();
                            System.out.println("Row Value: " + rowValue);
                            break;
                        default:
                            System.out.println("Unknown column " + stringCellValue);
                    }
                }
            }
            //  System.out.println("Result" + store);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fileInputStream.close();
            workbook.close();
        }
    }

    public void writeData(String fileName) throws IOException {
        File writeFile = new File(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(writeFile);
        Workbook workbook = new XSSFWorkbook();
        workbook.write(fileOutputStream);
        workbook.close();
    }
}
