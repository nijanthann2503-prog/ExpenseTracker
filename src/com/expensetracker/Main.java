package com.expensetracker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ExpenseDAO dao = new ExpenseDAO();
    private static Scanner sc = new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // input & display format

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addExpense(); break;
                case 2: viewExpenses(); break;
                case 3: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void addExpense() throws Exception {
        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // consume newline

        System.out.print("Category: ");
        String category = sc.nextLine();

        System.out.print("Date (dd-MM-yyyy): ");
        String dateStr = sc.nextLine();
        Date date = sdf.parse(dateStr);

        Expense expense = new Expense(title, amount, category, date);
        dao.addExpense(expense);
        System.out.println("Expense added successfully!");
    }

    private static void viewExpenses() {
        List<Expense> expenses = dao.getAllExpenses();
        System.out.println("\nID | Title | Amount | Category | Date");
        System.out.println("-------------------------------------------");
        for (Expense e : expenses) {
            String dateStr = (e.getExpenseDate() != null) ? sdf.format(e.getExpenseDate()) : "N/A";
            System.out.println(
                e.getId() + " | " +
                e.getTitle() + " | " +
                e.getAmount() + " | " +
                e.getCategory() + " | " +
                dateStr
            );
        }
    }
}
