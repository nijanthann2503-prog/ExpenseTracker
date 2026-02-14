package com.expensetracker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {

    // Add expense
    public void addExpense(Expense expense) {
        String sql = "INSERT INTO expenses (title, amount, category, expense_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, expense.getTitle());
            stmt.setDouble(2, expense.getAmount());
            stmt.setString(3, expense.getCategory());

            // Convert java.util.Date to java.sql.Date
            if (expense.getExpenseDate() != null) {
                stmt.setDate(4, new java.sql.Date(expense.getExpenseDate().getTime()));
            } else {
                stmt.setNull(4, Types.DATE);
            }

            stmt.executeUpdate();
            System.out.println("Expense added!");
        } catch (SQLException e) {
            System.out.println("Error adding expense:");
            e.printStackTrace();
        }
    }

    // Get all expenses
    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Expense expense = new Expense();
                expense.setId(rs.getInt("id"));
                expense.setTitle(rs.getString("title"));
                expense.setAmount(rs.getDouble("amount"));

                // Handle category safely
                String category = rs.getString("category");
                expense.setCategory(category != null ? category : "N/A");

                // Handle expense_date safely
                Date date = rs.getDate("expense_date");
                expense.setExpenseDate(date);

                expenses.add(expense);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching expenses:");
            e.printStackTrace();
        }
        return expenses;
    }

    // Optional: Add updateExpense() and deleteExpense() later
}
