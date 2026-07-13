# 🤖 AI-Enhanced Selenium Automation Framework

## 📌 Overview

This project is a scalable UI Automation Framework built using Java, Selenium WebDriver, TestNG, and Maven 
following industry-standard automation framework design principles.

The framework follows the Page Object Model (POM) design pattern and supports reusable components, 
data-driven testing, cross-browser execution, automatic reporting, screenshot capture, and retry mechanisms for reliable test automation.

## 🚀 Tech Stack

- Java 17
- Selenium WebDriver 4
- TestNG
- Maven
- Apache POI
- Log4j2
- Extent Reports
- Git & GitHub
- 
## 📂 Framework Structure
src
├── main
│   ├── java
│   │   ├── base
│   │   ├── constants
│   │   ├── driver
│   │   ├── pages
│   │   ├── reports
│   │   ├── retry
│   │   ├── listeners
│   │   └── utils
│   └── resources
│       ├── config.properties
│       └── TestData.xlsx

src
└── test
    ├── java
    │   ├── tests
    │   └── dataproviders

## ✨ Framework Features

- ✅ Page Object Model (POM)
- ✅ Base Test Architecture
- ✅ ThreadLocal WebDriver
- ✅ Cross Browser Support
- ✅ Config Reader Utility
- ✅ Data-Driven Testing using Excel
- ✅ Retry Failed Test Cases
- ✅ TestNG Listeners
- ✅ Screenshot on Failure
- ✅ Extent HTML Reports
- ✅ Explicit Wait Utility
- ✅ Common Reusable Actions
- ✅ Log4j2 Logging
- ✅ Maven Project Structure

## 🧪 Test Flow

Login

↓

Add Product to Cart

↓

Verify Product

↓

Checkout

↓

Place Order

↓

Verify Success Message

## 📊 Reports

After execution:
Reports/
AutomationReport.html

## 📸 Screenshots

Include screenshots of:

- Framework Structure
- Test Execution
- Extent Report

## ▶ Run Project

```bash
mvn clean test

## 👩‍💻 Author
Banashankari Kammar
QA Automation Engineer
