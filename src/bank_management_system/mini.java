package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class mini extends JFrame implements ActionListener {
    String pin;
    JButton button;

    mini(String pin) {
        this.pin = pin;

        // Set background color for the window
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);

        // Label to display mini statement transactions
        JLabel label1 = new JLabel();
        label1.setBounds(20, 140, 360, 200); // Adjust width and height as needed
        label1.setFont(new Font("System", Font.PLAIN, 14)); // Set font for better readability
        add(label1);

        // Label to display title
        JLabel label2 = new JLabel("TechCoder A.V");
        label2.setFont(new Font("System", Font.BOLD, 15));
        label2.setBounds(150, 20, 200, 20);
        add(label2);

        // Label to display the card number
        JLabel label3 = new JLabel();
        label3.setBounds(20, 80, 360, 20); // Adjust the position and width
        label3.setFont(new Font("System", Font.PLAIN, 14));
        add(label3);

        // Label to display total balance
        JLabel label4 = new JLabel();
        label4.setBounds(20, 400, 360, 20); // Adjust position
        label4.setFont(new Font("System", Font.BOLD, 16));
        add(label4);

        // Fetch card number
        try {
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("select * from login where pin = '" + pin + "'");
            while (resultSet.next()) {
                label3.setText("Card Number:  " + resultSet.getString("card_number").substring(0, 4) + "XXXXXXXX" + resultSet.getString("card_number").substring(12));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error fetching card details");
            e.printStackTrace();
        }

        // Fetch transaction history and calculate balance
        try {
            int balance = 0;
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '" + pin + "'");
            while (resultSet.next()) {
                // Append each transaction to the statement
                label1.setText(label1.getText() + "<html>" + resultSet.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("amount") + "<br><br><html>");

                // Calculate balance based on transactions
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            label4.setText("Your Total Balance is Rs " + balance);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error fetching transaction details");
            e.printStackTrace();
        }

        // Exit button functionality
        button = new JButton("Exit");
        button.setBounds(20, 500, 100, 25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false); // Close the window when "Exit" is clicked
    }

    public static void main(String[] args) {
        new mini("");
    }
}
