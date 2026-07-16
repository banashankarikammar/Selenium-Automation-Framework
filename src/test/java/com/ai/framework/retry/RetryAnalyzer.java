package com.ai.framework.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int MAX_RETRY = 2;

    @Override
    public boolean retry(ITestResult result) {

        System.out.println("Retry Count : " + count);

        if (count < MAX_RETRY) {
            count++;
            return true;
        }

        return false;
    }
}