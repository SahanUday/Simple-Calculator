import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JPanel buttonPanel;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, percButton;
    JButton decButton, equButton, delButton, clrButton, negButton;

    Font textFont = new Font("SansSerif", Font.BOLD, 55);
    Font buttonFont = new Font("SansSerif", Font.BOLD, 24);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    SimpleCalculator() {
        // Frame setup
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.BLACK);

        // Text field setup
        textField = new JTextField();
        textField.setFont(textFont);
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        textField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        textField.setPreferredSize(new Dimension(400, 150));

        // Button setup
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        percButton = new JButton("%");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("AC");
        negButton = new JButton("+/-");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = percButton;

        for (JButton button : functionButtons) {
            button.addActionListener(this);
            button.setFont(buttonFont);
            button.setFocusable(false);
            button.setBackground(new Color(0x333333));
            button.setForeground(Color.WHITE);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(buttonFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(new Color(0x666666));
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        equButton.setBackground(new Color(0xFFA500)); // Orange for "=" button
        clrButton.setBackground(new Color(0xFF4444)); // Red for "AC"
    
        // Panel setup
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(Color.BLACK);

        // Add buttons to the panel
        buttonPanel.add(divButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(subButton);
        buttonPanel.add(addButton);
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(negButton);
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(delButton);
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(clrButton);
        buttonPanel.add(decButton);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(percButton);
        buttonPanel.add(equButton);
        
        // Add components to frame
        frame.add(textField, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == percButton) {
            num1 = Double.parseDouble(textField.getText());
            result = num1 / 100;
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String text = textField.getText();
            if (text.length() > 0) {
                textField.setText(text.substring(0, text.length() - 1));
            }
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}

