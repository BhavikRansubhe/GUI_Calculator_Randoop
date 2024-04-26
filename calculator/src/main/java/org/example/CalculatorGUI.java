package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {

    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;

    private double num1, num2, result;
    private String operator;

    public CalculatorGUI() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setEditable(false);
        add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        add(buttonPanel, BorderLayout.CENTER);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            buttonPanel.add(numberButtons[i]);
        }

        operatorButtons = new JButton[4];
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("/");
        for (JButton button : operatorButtons) {
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        JButton equalsButton = new JButton("=");
        equalsButton.addActionListener(this);
        buttonPanel.add(equalsButton);

        JButton clearButton = new JButton("C");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.matches("\\d")) { // If the button clicked is a number
            displayField.setText(displayField.getText() + command);
        } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) { // If the button clicked is an operator
            num1 = Double.parseDouble(displayField.getText());
            operator = command;
            displayField.setText("");
        } else if (command.equals("=")) { // If the button clicked is equals
            num2 = Double.parseDouble(displayField.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            displayField.setText(String.valueOf(result));
        } else if (command.equals("C")) { // If the button clicked is clear
            displayField.setText("");
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
