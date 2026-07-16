package com.ai.framework.tests;

import com.ai.framework.utils.ExcelUtility;
import org.testng.annotations.Test;

public class ExcelTest {

    @Test
    public void readExcel() {

        ExcelUtility excel = new ExcelUtility(
                "src/main/resources/TestData.xlsx",
                "LoginData");

        String username = excel.getCellData(1,0);
        String password = excel.getCellData(1,1);

        System.out.println(username);
        System.out.println(password);

    }
}