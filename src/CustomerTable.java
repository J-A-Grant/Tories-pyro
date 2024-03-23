import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomerTable extends JFrame {

    private DefaultTableModel tableModel;
    private JTable table;

    public CustomerTable(String customerId) {
        setTitle("Customer Appliances - ID: " + Customer.customerId);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create table model with appropriate column names
        String[] columnNames = {"Customer ID", "Product Name", "Status", "Price"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        // Read data from the file and populate the table
        String filePath = "C:\\Users\\Owner\\Documents\\Documents\\ATL code\\src\\CustomerFile.txt";  // Adjust the file path accordingly
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length >= 8 && tokens[0].equals(Customer.customerId)) {
                    String productName = tokens[9];
                    String[] appliances = productName.split("_");
                    String status = tokens[6];
                    String price = tokens[4];
                    int num = Integer.parseInt(tokens[7]);

                    int count=0;
                    
                    for (String appliance : appliances) {
                        if (count < num) {
                            tableModel.addRow(new String[]{Customer.customerId, appliance, status, price});
                        } else {
                            // If the counter is equal to or greater than num, add a row with status set to "INACTIVE"
                            tableModel.addRow(new String[]{Customer.customerId, appliance, "INACTIVE", "NONE"});
                        }
                        count++; // 
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add table to scroll pane and then to the frame
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        // Set frame properties
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Example usage: Display appliances for customer with ID "620000"
        SwingUtilities.invokeLater(() -> new CustomerTable("620000"));
    }
}
