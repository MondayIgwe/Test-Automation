package org.web.qa.io;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Objects;

public class ReadInput {

    private final XSSFWorkbook xssfWorkbook;
    private XSSFSheet xssfSheet;
    private XSSFRow xssfRow;
    private XSSFCell xssfCell;
    private final FileInputStream fileInputStream;


    public ReadInput(String fileName) throws IOException {
        // Create a File instance to locate the xlsx file
        File file = new File(fileName);
        boolean isFile = file.isFile();
        if (!isFile) {
            throw new FileNotFoundException("File not found: " + fileName);
        } else {
            // Create an InputStream to read the xlsx file
            fileInputStream = new FileInputStream(file);
            // Create a Workbook instance and read the xlsx file
            xssfWorkbook = new XSSFWorkbook(fileInputStream); // data.xlsx file
        }
    }

    public void readData(String sheetName) throws IOException {
        try {
            xssfSheet = xssfWorkbook.getSheet(sheetName);
            if (xssfSheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            } else {
                int rows = xssfSheet.getLastRowNum();

                for (int row = 0; row <= rows; row++) {
                    int cols = xssfSheet.getRow(row).getLastCellNum();
                    for (int j = row; j < cols; j++) {
                        xssfRow = xssfSheet.getRow(row);
                        xssfCell = xssfRow.getCell(j);

                        // Retrieve all types of cells data
                        CellType cellType = xssfCell.getCellType();
                        switch (cellType) {

                            case STRING:
                                System.out.println("Get String type: " + xssfCell.getStringCellValue());

                                XSSFCell data = xssfSheet.getRow(row + 1).getCell(j);
                                if (xssfCell.getStringCellValue().equalsIgnoreCase("id")) {
                                    System.out.println("perform action: " + data);
                                }
                                if (xssfCell.getStringCellValue().equalsIgnoreCase("first_name")) {
                                    System.out.println("perform action: " + data);
                                }
                                if (xssfCell.getStringCellValue().equalsIgnoreCase("last_name")) {
                                    System.out.println("perform action: " + data);
                                }
                                if (xssfCell.getStringCellValue().equalsIgnoreCase("email")) {
                                    System.out.println("perform action: " + data);
                                }
                                if (xssfCell.getStringCellValue().equalsIgnoreCase("gender")) {
                                    System.out.println("perform action: " + data);
                                }
                                if (xssfCell.getStringCellValue().equalsIgnoreCase("ip_address")) {
                                    System.out.println("perform action: " + data);
                                }
                                break;
                            case NUMERIC:
                                System.out.println("Get Number type: " + xssfCell.getNumericCellValue());
                                break;
                            case BOOLEAN:
                                System.out.println("Get Number type: " + xssfCell.getBooleanCellValue());
                                break;
                            case BLANK:
                                System.out.println("Blank cell: " + xssfCell.getRawValue());
                                break;
                            default:
                                System.out.println("Invalid data " + cellType);
                        }
                    }

                }
            }
            //  System.out.println("Result" + store);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fileInputStream.close();
            xssfWorkbook.close();
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
