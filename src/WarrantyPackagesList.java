import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WarrantyPackagesList extends JFrame {

    public WarrantyPackagesList() {
        setTitle("Warranty Select");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create data for the table
        Object[][] data = {
                { "Regular Warranty One", "Three Appliances", "15000.00" },
                { "Regular Warranty Two", "Three Appliances", "20000.00" },
                { "Premium Warranty One", "Three Appliances", "30000.00" },
                { "Premium Warranty Two", "Three Appliances", "45000.00" },
        };

        // Create column names
        String[] columnNames = { "Warranty Name", "Appliances Included", "Price" };

        // Create a DefaultTableModel and JTable with the data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);

        // Add a mouse listener to the table to detect row selections
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Check if it's a single click
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) { // Check if a row is selected
                        String warrantyName = (String) table.getValueAt(selectedRow, 0);
                        String appliancesIncluded = (String) table.getValueAt(selectedRow, 1);
                        String price = (String) table.getValueAt(selectedRow, 2);
                        String warrantyInfo = ""; // Initialize the variable

                        if (warrantyName.equals("Regular Warranty One")) {
                            warrantyInfo = "This is a THREE (3) Months Warranty of any 3 appliances of your choice.";
                        } else if (warrantyName.equals("Regular Warranty Two")) {
                            warrantyInfo = "This is a FIVE (5) Months Warranty of any 3 appliances of your choice.";
                        } else if (warrantyName.equals("Premium Warranty One")) {
                            warrantyInfo = "This is a EIGHT (8) Months Warranty of any 3 appliances of your choice.";
                        } else if (warrantyName.equals("Premium Warranty Two")) {
                            warrantyInfo = "This is a TWELVE (12) Months Warranty of any 3 appliances of your choice.";
                        }

                        // Display the selected warranty information
                        JOptionPane.showMessageDialog(null,
                                "Selected Warranty:\n\n" +
                                        "Name: " + warrantyName + "\n" +
                                        "Appliances Included: " + appliancesIncluded + "\n" +
                                        "Price: $" + price + "\n" +
                                        "Info: " + warrantyInfo,
                                "Selected Warranty",
                                JOptionPane.INFORMATION_MESSAGE);

                        // After selecting a warranty, display the customer appliances table
                        callCustomerAppliancesTable();
                    }
                }
            }
        });

        // Create a scroll pane to hold the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        add(scrollPane);

        // Set frame properties
        setSize(400, 300);
    }

    private void callCustomerAppliancesTable() {
        // Create and show the CustomerAppliancesTable GUI
        CustomerTable customerTable = new CustomerTable(Customer.customerId);
        customerTable.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WarrantyPackagesList warrantyList = new WarrantyPackagesList();
            warrantyList.setVisible(true);
        });
    }
}
