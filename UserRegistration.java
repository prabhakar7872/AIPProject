/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_tic_tac_toe;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import tictoc.TicTocGUI;

public class UserRegistration extends JFrame {

    JTextField nameField, ageField;
    JPasswordField passwordField;
    JButton registerButton, loginButton;

    public UserRegistration() {

        setTitle("🎮 User Login / Registration");
        setSize(380, 330);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(230, 230, 250));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        nameField = new JTextField(15);
        nameField.setFont(labelFont);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelFont);
        passwordField = new JPasswordField(15);
        passwordField.setFont(labelFont);

        JLabel ageLabel = new JLabel("Age (only for registration):");
        ageLabel.setFont(labelFont);
        ageField = new JTextField(15);
        ageField.setFont(labelFont);

        registerButton = new JButton("Register");
        loginButton = new JButton("Login");

        styleButton(registerButton);
        styleButton(loginButton);

        // Layout placement
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(ageLabel, gbc);
        gbc.gridx = 1;
        panel.add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(registerButton, gbc);
        gbc.gridx = 1;
        panel.add(loginButton, gbc);

        add(panel);

        registerButton.addActionListener(e -> registerUser());
        loginButton.addActionListener(e -> loginUser());

        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(120, 35));
    }

    private void registerUser() {
        String name = nameField.getText().trim();
        String password = new String(passwordField.getPassword());
        String ageText = ageField.getText().trim();

        if (name.isEmpty() || password.isEmpty() || ageText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields for registration.");
            return;
        }

        try {
            int age = Integer.parseInt(ageText);
            int userId;
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gameDB", "root", "787244")) {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO users (name, password, age) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, name);
                ps.setString(2, password);
                ps.setInt(3, age);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                userId = -1;
                if (rs.next()) userId = rs.getInt(1);
            }

            JOptionPane.showMessageDialog(this, "Registration Successful!");
            this.dispose();
            new TicTocGUI(userId).setVisible(true);

        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(this, "User already exists. Please login.");
        } catch (HeadlessException | NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void loginUser() {
        String name = nameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (name.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both name and password.");
            return;
        }

        try {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gameDB", "root", "787244")) {
                PreparedStatement ps = conn.prepareStatement("SELECT id, password FROM users WHERE name = ?");
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    if (storedPassword.equals(password)) {
                        int userId = rs.getInt("id");
                        JOptionPane.showMessageDialog(this, "Login successful!");
                        this.dispose();
                        new TicTocGUI(userId).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Incorrect password. Try again.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Name not found. Please register.");
                }
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void storeScore(int userId, int score) {
        try {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gameDB", "root", "787244")) {
                String query = "INSERT INTO user_scores (user_id, score, game_date) VALUES (?, ?, NOW())";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, userId);
                ps.setInt(2, score);
                
                ps.executeUpdate();
            }
        } catch (SQLException e) {
        }
    }

    public static int getUserTotalScore(int userId) {
        int totalScore = 0;
        try {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gameDB", "root", "787244")) {
                String query = "SELECT SUM(score) FROM user_scores WHERE user_id = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, userId);
                
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    totalScore = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
        }
        return totalScore;
    }
}
