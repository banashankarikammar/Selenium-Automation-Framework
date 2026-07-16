package com.ai.framework.dataproviders;

import com.ai.framework.utils.ExcelUtility;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        ExcelUtility excel =
                new ExcelUtility(
                        "src/main/resources/TestData.xlsx",
                        "LoginData");

        Object[][] data = new Object[1][2];

        data[0][0] = excel.getCellData(1, 0);

        data[0][1] = excel.getCellData(1, 1);

        return data;

    }

}