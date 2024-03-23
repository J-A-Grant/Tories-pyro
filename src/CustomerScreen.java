import java.awt.BorderLayout;
import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
//import javax.swing.table.DefaultTableModel;

public class CustomerScreen extends JFrame {

    //private static final String USER_FILE_PATH = "CustomerFile.txt";
    
   
    // Buttons panel properties
    private JPanel buttonsP = new JPanel();

    // Create buttons for the main application window
    private JButton warrantyB = new JButton("Get Warranty Plan");
    private JButton productLB = new JButton("See Personal Product List");
    private JButton scheduleB = new JButton("Schedule Servicing");
    private JButton notifB = new JButton("Notifications");
    private JButton ticket = new JButton("Add Support Ticket");
    private JButton payment = new JButton(" Pay for Warranty");

    public CustomerScreen(String customerId) {

        setTitle("Welcome " + Customer.customerId);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Format for buttons
        warrantyB.setBackground(Color.BLUE);
        warrantyB.setForeground(Color.WHITE);
        productLB.setBackground(Color.BLUE);
        productLB.setForeground(Color.WHITE);
        scheduleB.setBackground(Color.BLUE);
        scheduleB.setForeground(Color.WHITE);
        notifB.setBackground(Color.BLUE);
        notifB.setForeground(Color.WHITE);
        ticket.setBackground(Color.BLUE);
        ticket.setForeground(Color.WHITE);
        payment.setBackground(Color.BLUE);
        payment.setForeground(Color.WHITE);

        // Sets action listeners to buttons
        warrantyB.addActionListener(new warrantyBListener());
        productLB.addActionListener(new productLBListener());
        scheduleB.addActionListener(new scheduleBListener());
        //notifB.addActionListener(new notifBListener());
        ticket.addActionListener(new ticketListener());
        payment.addActionListener(new paymentListener());   

        // Add buttons to the main frame
        buttonsP.setLayout(new GridLayout(2, 1));
        buttonsP.add(warrantyB);
        buttonsP.add(productLB);
        buttonsP.add(scheduleB);
        buttonsP.add(notifB);
        buttonsP.add(ticket);
        buttonsP.add(payment);

        // Set frame properties
        getContentPane().add(buttonsP, BorderLayout.CENTER);
        setSize(800, 400);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

   
    private class warrantyBListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // SelectWarranty warrantyB = new SelectWarranty("customerid");
            // warrantyB.setVisible(true);
            SelectWarranty warrantyB = new SelectWarranty(Customer.customerId);
            warrantyB.setVisible(true);
        }
    }

    private class productLBListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Create and display a new ProductList window when the action is performed
            CustomerTable customer = new CustomerTable(Customer.customerId);
            customer.setVisible(true);
        }
    }

    private class scheduleBListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ServiceSchedulerGUI scheduleB = new ServiceSchedulerGUI();
            scheduleB.setVisible(true);
        }
    }

    // private class notifBListener implements ActionListener {
    //     public void actionPerformed(ActionEvent e) {
    //         // Handle register button click
    //         ShowNotification notifB = new ShowNotification();
    //         notifB.setVisible(true);
    //     }
    // }

    private class ticketListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Handle register button click
            GenerateSupportTicket support = new GenerateSupportTicket(Customer.customerId);
            support.setVisible(true);
        }
    }

    private class paymentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Handle register button click
            List<String> packages = new ArrayList<>();
            packages.add("Regular");
            packages.add("Premium1");
            packages.add("Premium2");
            /*
             * Customer customer= new Customer(620000,John Brown,Letm3$,876-881-8812,Premium
             * 1,11/10/2023,ACTIVE,Television Blender Fridge,1200_3540_6630,11/12/2023,2:00
             * pm);
             * )
             * new Payment(620000, packages);
             * payment.setVisible(true);
            */
        }
    }

    // private DefaultTableModel readDataFromFile() {
    //     // Read data from file and return DefaultTableModel
    //     return null; // Placeholder, implement as per your requirements
    // }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomerScreen("CustomerID"));
    }
}
