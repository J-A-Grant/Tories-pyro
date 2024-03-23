import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.ArrayList;
// import java.util.List;
//import java.util.Scanner;

public class SelectWarranty extends JFrame {
    private JButton cmdSelectWarranty;
    private JList<String> productList;
    private DefaultListModel<String> productListModel;

    public SelectWarranty(String customerId) {
        setTitle("Product List");

        // Load product data based on the person's ID
        //List<String> products = loadProductsForPerson(iD);

        // Create a DefaultListModel with the loaded data
        // productListModel = new DefaultListModel<>();
        // for (String product : products) {
        //     productListModel.addElement(product);
        // }

        WarrantyPackagesList warrantyPackagesList = new WarrantyPackagesList();
        warrantyPackagesList.setVisible(true); // Make the warranty list frame visible

        // Create a JList with the loaded data
        productList = new JList<>(productListModel);

        // Create a scroll pane to hold the list
        JScrollPane scrollPane = new JScrollPane(productList);

        // Create buttons
        cmdSelectWarranty = new JButton("Select Warranty");
        cmdSelectWarranty.addActionListener(new SelectWarrantyActionListener());

        JButton cmdAddWarranty = new JButton("Add Warranty");
        cmdAddWarranty.addActionListener(new AddWarrantyActionListener());

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(); // Separate panel for buttons
        buttonPanel.add(cmdSelectWarranty);
        buttonPanel.add(cmdAddWarranty);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the panel to the frame
        add(panel);

        // Set frame properties
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    // private List<String> loadProductsForPerson(String personId) {
    //     CustomerTable customerTable = new CustomerTable(Customer.customerId);
    //     customerTable.setVisible(true);
    //     return new ArrayList<>(); // Return an empty list since no products are loaded
    // }

    // private List<String> loadProductsForPerson(String personId) {

    //     CustomerTable customerTable = new CustomerTable();
    //     customerTable.setVisible(true);

    //     List<String> productsList = new ArrayList<>();

    //     // String filePath = "C:\\Users\\Owner\\Documents\\Documents\\ATL code\\src\\CustomerFile.txt";
    
    //     // try {
    //     //     Scanner scanner = new Scanner(new File(filePath));
    //     //     while (scanner.hasNextLine()) {
    //     //         String line = scanner.nextLine();
    //     //         String[] values = line.split(",");
    //     //         if (values.length >= 8 && values[0].equals(personId)) {
    //     //             String[] eighthToken = values[7].split("_");
    //     //             for (String token : eighthToken) {
    //     //                 productsList.add(token);
    //     //             }
    //     //         }
    //     //     }
    //     //     scanner.close();
    //     // } catch (FileNotFoundException e) {
    //     //    e.printStackTrace();
        

    //     return productsList;
    // }

    private class AddWarrantyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get selected products
            int[] selectedIndices = productList.getSelectedIndices();
            StringBuilder selectedProducts = new StringBuilder("Selected Products:\n");
            for (int index : selectedIndices) {
                selectedProducts.append(productListModel.getElementAt(index)).append("\n");
            }

            // Display a message with the selected products
            // JOptionPane.showMessageDialog(ProductList.this, selectedProducts.toString());
        }
    }

    private class SelectWarrantyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Open warranty select
            WarrantyPackagesList warrantyPackagesList = new WarrantyPackagesList();
            warrantyPackagesList.setVisible(true); // Make the warranty list frame visible
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SelectWarranty selectWarranty = new SelectWarranty("customerID");
            selectWarranty.setVisible(true);
        });
    }
    
}
