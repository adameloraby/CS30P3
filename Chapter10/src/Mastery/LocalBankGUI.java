package Mastery;

import java.awt.*;
import java.text.NumberFormat;
import javax.swing.*;

public class LocalBankGUI {

    private JFrame frame;

    // Labels (above fields)
    private JLabel lblAccountID, lblAmount, lblFirstName, lblLastName, lblBeginBalance;

    // Input fields
    private JTextField acctField, amtField, fNameField, lNameField, balanceField;

    // Action selector and result
    private JComboBox<String> actionList;
    private JLabel resultLabel;

    // Backend
    private Bank bank;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LocalBankGUI window = new LocalBankGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LocalBankGUI() {
        bank = new Bank();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("LocalBankGUI");
        frame.setBounds(100, 100, 420, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(new Color(240, 240, 240));

        // Dropdown for actions
        JLabel actionLabel = new JLabel("Select an action:");
        actionLabel.setBounds(20, 10, 120, 20);
        frame.getContentPane().add(actionLabel);

        String[] actions = {"Deposit", "Withdraw", "Add Account", "Delete Account", "Check Balance"};
        actionList = new JComboBox<>(actions);
        actionList.setBounds(150, 10, 230, 24);
        frame.getContentPane().add(actionList);

        JLabel instruction = new JLabel("Complete the information in RED");
        instruction.setBounds(20, 40, 300, 20);
        frame.getContentPane().add(instruction);

        // Account ID
        lblAccountID = new JLabel("Account ID");
        lblAccountID.setBounds(20, 70, 120, 18);
        frame.getContentPane().add(lblAccountID);
        acctField = new JTextField();
        acctField.setBounds(20, 90, 360, 24);
        frame.getContentPane().add(acctField);

        // Amount
        lblAmount = new JLabel("Amount (deposit/withdrawal)");
        lblAmount.setBounds(20, 120, 250, 18);
        frame.getContentPane().add(lblAmount);
        amtField = new JTextField();
        amtField.setBounds(20, 140, 360, 24);
        frame.getContentPane().add(amtField);

        // First Name
        lblFirstName = new JLabel("First Name");
        lblFirstName.setBounds(20, 170, 120, 18);
        frame.getContentPane().add(lblFirstName);
        fNameField = new JTextField();
        fNameField.setBounds(20, 190, 360, 24);
        frame.getContentPane().add(fNameField);

        // Last Name
        lblLastName = new JLabel("Last Name");
        lblLastName.setBounds(20, 220, 120, 18);
        frame.getContentPane().add(lblLastName);
        lNameField = new JTextField();
        lNameField.setBounds(20, 240, 360, 24);
        frame.getContentPane().add(lNameField);

        // Beginning Balance
        lblBeginBalance = new JLabel("Beginning Balance");
        lblBeginBalance.setBounds(20, 270, 150, 18);
        frame.getContentPane().add(lblBeginBalance);
        balanceField = new JTextField();
        balanceField.setBounds(20, 290, 360, 24);
        frame.getContentPane().add(balanceField);

        // Result area
        resultLabel = new JLabel("Account Info Displayed Here");
        resultLabel.setVerticalAlignment(SwingConstants.TOP);
        resultLabel.setBounds(20, 320, 360, 100); // larger for multi-line output
        resultLabel.setOpaque(true);
        resultLabel.setBackground(new Color(240, 240, 240));
        frame.getContentPane().add(resultLabel);

        JButton processBtn = new JButton("Process Transaction");
        processBtn.setBounds(110, 430, 200, 28);
        frame.getContentPane().add(processBtn);

        // listeners
        actionList.addActionListener(e -> updateRequiredFields());
        processBtn.addActionListener(e -> processAction());

        updateRequiredFields();
    }

    private void updateRequiredFields() {
        Color defaultColor = Color.BLACK;
        lblAccountID.setForeground(defaultColor);
        lblAmount.setForeground(defaultColor);
        lblFirstName.setForeground(defaultColor);
        lblLastName.setForeground(defaultColor);
        lblBeginBalance.setForeground(defaultColor);

        Color req = Color.RED;
        String action = (String) actionList.getSelectedItem();
        switch (action) {
            case "Deposit":
            case "Withdraw":
                lblAccountID.setForeground(req);
                lblAmount.setForeground(req);
                break;
            case "Add Account":
                lblFirstName.setForeground(req);
                lblLastName.setForeground(req);
                lblBeginBalance.setForeground(req);
                break;
            case "Delete Account":
            case "Check Balance":
                lblAccountID.setForeground(req);
                break;
        }
    }

    private void processAction() {
        // Reset display
        resultLabel.setText("");

        String action = (String) actionList.getSelectedItem();
        String acctID = acctField.getText().trim();
        String amtText = amtField.getText().trim();
        String fName = fNameField.getText().trim();
        String lName = lNameField.getText().trim();
        String balText = balanceField.getText().trim();

        boolean success = false;
        String result;

        try {
            switch (action) {
                case "Add Account": {
                    if (fName.isEmpty() || lName.isEmpty()) {
                        result = "First and last name are required.";
                        break;
                    }
                    double startBal = balText.isEmpty() ? 0 : Double.parseDouble(balText);
                    String newId = bank.addAccount(fName, lName, startBal);
                    result = "<b>Account created successfully</b><br>" +
                             "Account ID: " + newId + "<br>" +
                             "Name: " + fName + " " + lName + "<br>" +
                             "Beginning Balance: " + money(startBal);
                    success = true;
                    break;
                }
                case "Delete Account": {
                    if (acctID.isEmpty()) {
                        result = "Account ID is required.";
                        break;
                    }
                    String delRes = bank.deleteAccount(acctID);
                    if (delRes.equals("Account removed.")) {
                        result = "<b>Account deleted successfully</b><br>" +
                                 "Account ID: " + acctID;
                        success = true;
                    } else {
                        result = delRes;
                    }
                    break;
                }
                case "Deposit": {
                    if (acctID.isEmpty() || amtText.isEmpty()) {
                        result = "Account ID and amount are required.";
                        break;
                    }
                    double depAmt = Double.parseDouble(amtText);
                    String raw = bank.transaction(1, acctID, depAmt);
                    if (!raw.equals("Account does not exist.")) {
                        ParsedAccount acct = parseAccountInfo(raw);
                        result = "<b>Deposit complete</b><br>" +
                                 "Account ID: " + acct.id + "<br>" +
                                 "Name: " + acct.firstName + " " + acct.lastName + "<br>" +
                                 "Deposit Amount: " + money(depAmt) + "<br>" +
                                 "New Balance: " + money(acct.balance);
                        success = true;
                    } else {
                        result = raw;
                    }
                    break;
                }
                case "Withdraw": {
                    if (acctID.isEmpty() || amtText.isEmpty()) {
                        result = "Account ID and amount are required.";
                        break;
                    }
                    double wdAmt = Double.parseDouble(amtText);
                    String raw = bank.transaction(2, acctID, wdAmt);
                    if (!raw.equals("Account does not exist.")) {
                        ParsedAccount acct = parseAccountInfo(raw);
                        result = "<b>Withdrawal complete</b><br>" +
                                 "Account ID: " + acct.id + "<br>" +
                                 "Name: " + acct.firstName + " " + acct.lastName + "<br>" +
                                 "Withdrawal Amount: " + money(wdAmt) + "<br>" +
                                 "New Balance: " + money(acct.balance);
                        success = true;
                    } else {
                        result = raw;
                    }
                    break;
                }
                case "Check Balance": {
                    if (acctID.isEmpty()) {
                        result = "Account ID is required.";
                        break;
                    }
                    String raw = bank.checkBalance(acctID);
                    if (!raw.equals("Account does not exist.")) {
                        ParsedAccount acct = parseAccountInfo(raw);
                        result = "<b>Balance check</b><br>" +
                                 "Account ID: " + acct.id + "<br>" +
                                 "Name: " + acct.firstName + " " + acct.lastName + "<br>" +
                                 "Current Balance: " + money(acct.balance);
                        success = true;
                    } else {
                        result = raw;
                    }
                    break;
                }
                default:
                    result = "Unknown action.";
            }
        } catch (NumberFormatException nfe) {
            result = "Invalid number format.";
        }

        resultLabel.setText("<html>" + result.replace("\n", "<br>") + "</html>");
        if (success) clearAllInputs();
        updateRequiredFields();
        resultLabel.repaint();
    }

    private void clearAllInputs() {
        acctField.setText("");
        amtField.setText("");
        fNameField.setText("");
        lNameField.setText("");
        balanceField.setText("");
    }

    /** Struct for parsed account info */
    private static class ParsedAccount {
        String id;
        String firstName;
        String lastName;
        double balance;
    }

    /** Parse Account.toString() into structured parts */
    private ParsedAccount parseAccountInfo(String raw) {
        ParsedAccount pa = new ParsedAccount();
        try {
            // Example raw: "JSmith  John Smith  Current balance is $500.00"
            String[] parts = raw.split("Current balance is");
            String before = parts[0].trim();
            String balanceStr = parts[1].trim();

            String[] tokens = before.split("\\s+");
            pa.id = tokens[0];
            pa.firstName = tokens.length > 1 ? tokens[1] : "";
            pa.lastName = tokens.length > 2 ? tokens[2] : "";

            NumberFormat nf = NumberFormat.getCurrencyInstance();
            pa.balance = nf.parse(balanceStr).doubleValue();
        } catch (Exception e) {
            pa.id = "";
            pa.firstName = "";
            pa.lastName = "";
            pa.balance = 0;
        }
        return pa;
    }

    private String money(double amt) {
        return NumberFormat.getCurrencyInstance().format(amt);
    }
}