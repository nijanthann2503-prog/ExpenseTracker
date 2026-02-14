# Expense Tracker

## Description
A simple **Java console application** to track expenses using a **MySQL database**.  
Supports adding and viewing expenses with proper **Category** and **Date** management.  
Built using **Java, JDBC, and MySQL** with an object-oriented design.

---

## Features
- Add new expenses with title, amount, category, and date
- View all expenses in a clean table format
- Uses **dd-MM-yyyy** date format
- Uses **JDBC** to connect Java to MySQL
- Fully object-oriented (classes: `DBConnection`, `Expense`, `ExpenseDAO`, `Main`)

---

## Prerequisites
- Java JDK 8 or above
- MySQL Community Server
- MySQL Workbench (optional, for database management)
- MySQL Connector/J (JAR file)

---

## Setup Instructions

### 1. Clone the repository
```bash
git clone https://github.com/username/ExpenseTracker.git
cd ExpenseTracker

### 2. Create database and table
Run the following SQL commands in MySQL Workbench or CLI:

```sql
CREATE DATABASE IF NOT EXISTS expense_tracker;
USE expense_tracker;

DROP TABLE IF EXISTS expenses;

CREATE TABLE expenses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    amount DOUBLE NOT NULL,
    category VARCHAR(50),
    expense_date DATE
);

Update DBConnection.java

Open DBConnection.java in src/com/expensetracker/
Replace the placeholder with your MySQL root password:

private static final String PASSWORD = "YOUR_PASSWORD_HERE";

Example Console Output : 
--- Expense Tracker ---
1. Add Expense
2. View Expenses
3. Exit
Choose: 1
Title: Milk
Amount: 22
Category: Grocery
Date (dd-MM-yyyy): 14-02-2026
Expense added successfully!

--- Expense Tracker ---
1. Add Expense
2. View Expenses
3. Exit
Choose: 2

ID | Title | Amount | Category | Date
1  | Milk  | 22.0   | Grocery  | 14-02-2026

Project Structure :
ExpenseTracker/
├── src/
│   └── com/expensetracker/
│       ├── DBConnection.java
│       ├── Expense.java
│       ├── ExpenseDAO.java
│       └── Main.java
├── lib/
│   └── mysql-connector-j-8.x.x.jar
├── database.sql
├── .gitignore
└── README.md

License :
This project is open-source and free to use for learning or portfolio purposes
