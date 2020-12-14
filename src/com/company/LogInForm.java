package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LogInForm {

    private JFrame loginForm;
    private JButton loginButton;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LogInForm(String title) {
        this.loginForm = new JFrame(title);
        this.loginForm.setLocationRelativeTo(null);
        this.loginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(50, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        loginForm.setContentPane(panel);

        JLabel label = new JLabel(" Enter your information ");
        label.setBackground(Color.YELLOW);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width + 50;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));

        ButtonHandler handler = new ButtonHandler();

        JLabel unameLabel = new JLabel(" Username : ");
        usernameField = new JTextField("Enter Username ...");

        usernameField.addActionListener(handler);
        usernameField.addFocusListener(handler);

        JLabel psswdLabel = new JLabel(" Password : ");
        passwordField = new JPasswordField();

        passwordField.addActionListener(handler);
        passwordField.addFocusListener(handler);

        JPanel fieldsPanel = new JPanel(new GridLayout(2, 2, 50, 5));
        fieldsPanel.add(unameLabel);
        fieldsPanel.add(usernameField);
        fieldsPanel.add(psswdLabel);
        fieldsPanel.add(passwordField);


        loginButton = new JButton("Login");

        loginButton.addActionListener(handler);

        int buttonWidth = loginButton.getPreferredSize().width;
        int buttonHeight = loginButton.getPreferredSize().height + 10;
        loginButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        panel.add(label, BorderLayout.NORTH);
        panel.add(fieldsPanel, BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
    }

    public void showGUI() {
        loginForm.pack();
        loginForm.setVisible(true);
    }

    private class ButtonHandler implements ActionListener, FocusListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(loginButton)) {
                System.out.println("Button");
            } else if (e.getSource().equals(usernameField)) {
                System.out.println("User Field");
            } else if (e.getSource().equals(passwordField)) {
                System.out.println("Password Field");
            }

            String user = usernameField.getText();
            String pwd = new String(passwordField.getPassword());
            if (user.equals(pwd)) {
                JOptionPane.showMessageDialog(loginForm, "Successful!", "Result", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(loginForm, "Failed!", "Result", JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        public void focusGained(FocusEvent e) {
            displayMessage("Focus gained", e);

        }

        @Override
        public void focusLost(FocusEvent e) {
            displayMessage("Focus lost", e);

        }

        void displayMessage(String prefix, FocusEvent e) {
            System.out.println(prefix
                    + (e.isTemporary() ? " (temporary):" : ":")
                    + e.getComponent().getClass().getName()
                    + "; Opposite component: "
                    + (e.getOppositeComponent() != null ? e.getOppositeComponent().getClass().getName()
                    : "null"));
        }
    }

}
