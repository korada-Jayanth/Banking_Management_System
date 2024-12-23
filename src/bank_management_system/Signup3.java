package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6;
    JButton s, c;
    String formno;

    Signup3(String formno) {
        this.formno = formno;

        // Setup Frame
        setTitle("Account Details - Page 3");
        setSize(850, 800);
        setLocation(400, 20);
        setLayout(null);
        getContentPane().setBackground(new Color(215, 252, 252));

        // Add Bank Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(150, 5, 100, 100);
        add(image);

        // Add Labels
        addLabel("Page 3:", 280, 40, 400, 40, 22);
        addLabel("Account Details", 280, 70, 400, 40, 22);
        addLabel("Account Type:", 100, 140, 200, 30, 18);
        addLabel("Card Number:", 100, 300, 200, 30, 18);
        addLabel("(Your 16-digit Card Number)", 100, 330, 200, 20, 12);
        addLabel("XXXX-XXXX-XXXX-4841", 330, 300, 250, 30, 18);
        addLabel("(It would appear on atm card/cheque Book and Statements)", 330, 330, 500, 20, 12);
        addLabel("PIN:", 100, 370, 200, 30, 18);
        addLabel("XXXX", 330, 370, 200, 30, 18);
        addLabel("(4-digit Password)", 100, 400, 200, 20, 12);
        addLabel("Services Required:", 100, 450, 200, 30, 18);

        // Add Radio Buttons for Account Type
        r1 = createRadioButton("Saving Account", 100, 180, 150, 30);
        r2 = createRadioButton("Fixed Deposit Account", 350, 180, 300, 30);
        r3 = createRadioButton("Current Account", 100, 220, 250, 30);
        r4 = createRadioButton("Recurring Deposit Account", 350, 220, 250, 30);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        // Add Checkboxes for Services
        c1 = createCheckBox("ATM CARD", 100, 500, 200, 30);
        c2 = createCheckBox("Internet Banking", 350, 500, 200, 30);
        c3 = createCheckBox("Mobile Banking", 100, 550, 200, 30);
        c4 = createCheckBox("EMAIL Alerts", 350, 550, 200, 30);
        c5 = createCheckBox("Cheque Book", 100, 600, 200, 30);
        c6 = createCheckBox("E-Statement", 350, 600, 200, 30);

        // Add Declaration Checkbox
        JCheckBox c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.", true);
        c7.setBackground(new Color(215, 252, 252));
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 680, 600, 20);
        add(c7);

        // Add Form Number Label
        addLabel("Form No:", 700, 10, 100, 30, 14);
        addLabel(formno, 760, 10, 60, 30, 14);

        // Add Buttons (Submit and Cancel)
        s = createButton("Submit", 250, 720, 100, 30);
        c = createButton("Cancel", 420, 720, 100, 30);

        setVisible(true);
    }

    // Helper function to add JLabel
    private void addLabel(String text, int x, int y, int width, int height, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Raleway", Font.BOLD, fontSize));
        label.setBounds(x, y, width, height);
        add(label);
    }

    // Helper function to create a JRadioButton
    private JRadioButton createRadioButton(String text, int x, int y, int width, int height) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setFont(new Font("Raleway", Font.BOLD, 16));
        radioButton.setBackground(new Color(215, 252, 252));
        radioButton.setBounds(x, y, width, height);
        add(radioButton);
        return radioButton;
    }

    // Helper function to create a JCheckBox
    private JCheckBox createCheckBox(String text, int x, int y, int width, int height) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setBackground(new Color(215, 252, 252));
        checkBox.setFont(new Font("Raleway", Font.BOLD, 16));
        checkBox.setBounds(x, y, width, height);
        add(checkBox);
        return checkBox;
    }

    // Helper function to create a JButton with black text
    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setFont(new Font("Raleway", Font.BOLD, 14));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.BLACK);  // Set the text color to black
        button.setBounds(x, y, width, height);
        button.addActionListener(this);
        add(button);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String atype = null;
        if (r1.isSelected()) {
            atype = "Saving Account";
        } else if (r2.isSelected()) {
            atype = "Fixed Deposit Account";
        } else if (r3.isSelected()) {
            atype = "Current Account";
        } else if (r4.isSelected()) {
            atype = "Recurring Deposit Account";
        }

        // Generate random Card Number and PIN
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
        String cardno = "" + Math.abs(first7);
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        // Gather selected services
        StringBuilder services = new StringBuilder();
        if (c1.isSelected()) services.append("ATM CARD ");
        if (c2.isSelected()) services.append("Internet Banking ");
        if (c3.isSelected()) services.append("Mobile Banking ");
        if (c4.isSelected()) services.append("EMAIL Alerts ");
        if (c5.isSelected()) services.append("Cheque Book ");
        if (c6.isSelected()) services.append("E-Statement ");

        // Check if required fields are filled
        try {
            if (e.getSource() == s) {
                if (atype == null || services.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Please fill all required fields.");
                } else {
                    Connn c1 = new Connn();
                    String q1 = "insert into signupthree values('" + formno + "', '" + atype + "','" + cardno + "','" + pin + "','" + services.toString().trim() + "')";
                    String q2 = "insert into login values('" + formno + "','" + cardno + "','" + pin + "')";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n PIN: " + pin);
                    new Deposit(pin);
                    setVisible(false);
                }
            } else if (e.getSource() == c) {
                System.exit(0);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }
}
