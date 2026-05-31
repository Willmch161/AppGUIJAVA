import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        
        // [TAG: MAIN WINDOW]
        // Setting up the main frame (window) for the application.
        JFrame frame = new JFrame("Simple Contact App");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // [TAG: INPUT PANEL]
        // This panel holds the text fields for Name, Email, and Phone (matching the GitHub repo).
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Phone:"));
        inputPanel.add(phoneField);

        frame.add(inputPanel, BorderLayout.NORTH);

        // [TAG: TABLE SETUP]
        // Creating the table to display the contacts.
        String[] columns = {"Name", "Email", "Phone"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // [TAG: BUTTONS SETUP]
        // Creating the buttons and placing them at the bottom of the window.
        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("Add");
        JButton btnEdit = new JButton("Edit");
        JButton btnDelete = new JButton("Delete");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // ==========================================
        // [TAG: BUTTON ACTIONS (METHODS)]
        // ==========================================

        // [TAG: ADD METHOD]
        // Gets the text from Name, Email, and Phone fields and adds them as a new row.
        btnAdd.addActionListener(e -> {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();

            if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty()) {
                tableModel.addRow(new Object[]{name, email, phone});
                nameField.setText("");
                emailField.setText("");
                phoneField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields!");
            }
        });

        // [TAG: EDIT METHOD]
        // Checks which row you clicked in the table, and updates it with the new typed text.
        btnEdit.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String phone = phoneField.getText().trim();

                if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty()) {
                    tableModel.setValueAt(name, selectedRow, 0);
                    tableModel.setValueAt(email, selectedRow, 1);
                    tableModel.setValueAt(phone, selectedRow, 2);
                    nameField.setText("");
                    emailField.setText("");
                    phoneField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields to edit!");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a row from the table first.");
            }
        });

        // [TAG: DELETE METHOD]
        // Deletes the highlighted row from the table.
        btnDelete.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                tableModel.removeRow(selectedRow);
                nameField.setText("");
                emailField.setText("");
                phoneField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a row from the table to delete.");
            }
        });

        // [TAG: ROW CLICK AUTofill]
        // When you click a row in the table, it automatically puts the info back into the text boxes so you can edit it easily.
        table.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                nameField.setText(tableModel.getValueAt(selectedRow, 0).toString());
                emailField.setText(tableModel.getValueAt(selectedRow, 1).toString());
                phoneField.setText(tableModel.getValueAt(selectedRow, 2).toString());
            }
        });

        // [TAG: SHOW WINDOW]
        frame.setVisible(true);
    }
}   