import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GenerateSupportTicket extends JFrame {

    private JTable table;
    JFrame SupportFrame = new JFrame("Generate Support Ticket");

    public GenerateSupportTicket(String customerId) {
        CustomerTable customer = new CustomerTable(customerId);
        customer.setVisible(true);

        // Initialize the table
        table = new JTable();
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Allow multiple row selection


        table.addMouseListener(new MouseAdapter() {
            
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        String productName = (String) table.getValueAt(selectedRow, 0);
                        String appliances = (String) table.getValueAt(selectedRow, 1);
                        String status = (String) table.getValueAt(selectedRow, 2);
                        
                        String warrantyInfo = ""; // Initialize the variable

                        if (status.equals("INACTIVE")) {
                            warrantyInfo = "There is no warranty currently on this Product";
                        } else if (productName.equals("Regular Warranty Two")) {
                            warrantyInfo = "This is a FIVE (5) Months Warranty of any 3 appliances of your choice.";
                        }

                        // Display the selected warranty information
                        JOptionPane.showMessageDialog(null,
                                "Selected Warranty:\n\n" +
                                        "Name: " + productName + "\n" +
                                        "Appliance: " + appliances + "\n" +
                                        "Status: " + status + "\n" +
                                        "Info: " + warrantyInfo,
                                "Selected Warranty",
                                JOptionPane.INFORMATION_MESSAGE);

                            //String customerId = JOptionPane.showInputDialog(SupportFrame, "Enter Appliance:");

                        ServiceSchedulerGUI service = new ServiceSchedulerGUI();
                        service.setVisible(true);
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String customerId = Customer.customerId; 
            GenerateSupportTicket supportTicket = new GenerateSupportTicket(customerId);
            supportTicket.setVisible(true);
        });
    }
}
