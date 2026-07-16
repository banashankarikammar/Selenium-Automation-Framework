package com.ai.framework.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {

    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtility(String filePath, String sheetName) {

        try {

            FileInputStream fis = new FileInputStream(filePath);

            workbook = WorkbookFactory.create(fis);

            sheet = workbook.getSheet(sheetName);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public String getCellData(int row, int column) {

        return sheet.getRow(row).getCell(column).getStringCellValue();

    }

}