import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
//import javax.swing.table.DefaultTableModel;

public class HomeScreenGUI extends JFrame {
    private static final String USER_FILE_PATH = "C:\\Users\\Owner\\Documents\\Documents\\ATL code\\src\\CustomerFile.txt";
    private static final String WORKER_FILE_PATH = "worker_credentials.txt";

    // Create components
    private JPanel titleP = new JPanel();
    private JPanel displayP = new JPanel();
    private JPanel buttonsP = new JPanel();

    private JLabel welcomeLabel = new JLabel("WELCOME");
    private JButton customerButton = new JButton("Customer Login");
    private JButton workerButton = new JButton("Employee Login");
    private JButton CloseButton = new JButton("X");
   

    

    public HomeScreenGUI() {
        // Set frame properties
        setSize(500, 400);
        // Create SlideShow
        List<ImageIcon> imageIcons = new ArrayList<>();

        imageIcons.add(new ImageIcon(/* insert picture path */));
               
        setTitle("ATL APPLIANCES LIMITED");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Title panel properties
        // titleP.setForeground(Color.WHITE);
        titleP.add(welcomeLabel);
        welcomeLabel.setForeground(Color.RED);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 50));

        // Buttons panel properties
        buttonsP.setPreferredSize(new Dimension(100, 300));
        // buttonsP.setBackground(Color.RED);

        // Format for buttons
        customerButton.setBackground(Color.BLUE);
        customerButton.setForeground(Color.WHITE);
        workerButton.setBackground(Color.BLUE);
        workerButton.setForeground(Color.WHITE);
        CloseButton.setBackground(Color.BLUE);
        CloseButton.setForeground(Color.WHITE);

        // Sets action listeners to buttons
        customerButton.addActionListener(new customerListener());
        workerButton.addActionListener(new workerListener());
        CloseButton.addActionListener(new CloseListener());

        // Adds the buttons to the buttons panel
        buttonsP.add(customerButton, BorderLayout.CENTER);
        buttonsP.add(workerButton, BorderLayout.CENTER);
        buttonsP.add(CloseButton, BorderLayout.SOUTH);

        // Displays panels on frame
        displayP.add(buttonsP);
        add(titleP, BorderLayout.NORTH);
        add(displayP, BorderLayout.CENTER);

        setVisible(true);
    }

   

    private class CloseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class customerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            showCustomerLoginPrompt();
        }
    }

    private class workerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            showWorkerLoginPrompt();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        new HomeScreenGUI();
    }    
   
       
        

    public void showCustomerLoginPrompt() {
        JFrame loginFrame = new JFrame("Login");
        String customerId = JOptionPane.showInputDialog(loginFrame, "Enter User ID:");
        String password = JOptionPane.showInputDialog(loginFrame, "Enter Password:");

        // Perform authentication based on the entered ID and password
        if (authenticateCustomer(customerId, password)) {
            JOptionPane.showMessageDialog(loginFrame, "Login successful!");
            CustomerScreen customerScreen = new CustomerScreen(customerId);
            customerScreen.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(loginFrame, "Login failed. Invalid credentials.");
        }
    }

    private void showWorkerLoginPrompt() {
        JFrame loginFrame = new JFrame("Login");
        String workerID = JOptionPane.showInputDialog(loginFrame, "Enter ID:");
        String password = JOptionPane.showInputDialog(loginFrame, "Enter Password:");

        // Perform authentication based on the entered ID and password
        if (authenticateWorker(workerID, password)) {
            JOptionPane.showMessageDialog(loginFrame, "Login successful!");
            new WorkerScreen();

        } else {
            JOptionPane.showMessageDialog(loginFrame, "Login failed. Invalid credentials.");
        }
    }

    private boolean authenticateCustomer(String customerId, String password) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(USER_FILE_PATH));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");

                String iD = tokens[0];
                String pw = tokens[2];

                if (iD.equals(customerId) && pw.equals(password)) {
                    Customer.customerId=customerId;
                    return true;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }



    private boolean authenticateWorker(String workerID, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(WORKER_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into user ID and password
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String storedUserID = parts[0].trim();
                    String storedPassword = parts[1].trim();

                    // Check if the user ID and password match
                    if (storedUserID.equals(workerID) && storedPassword.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public class CheckIDAndPassword {

        public static void main(String[] args) {
            // Specify the path to your file
            String filePath = "C:\\Users\\Owner\\Documents\\Documents\\ATL code\\src";

            // Specify the target user ID and password to check
            String targetUserId = "620001";
            String targetPassword = "Letm3$"; // Password to check

            // Check if the ID and password match in the file
            boolean credentialsMatch = checkIDAndPassword(filePath, targetUserId, targetPassword);

            if (credentialsMatch) {
                System.out.println("ID and password match in the file.");
            } else {
                System.out.println("ID and password do not match or user not found in the file.");
            }
        }

        // Function to check if the ID and password match in the file
        private static boolean checkIDAndPassword(String filePath, String targetUserId, String targetPassword) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Check if the line contains the target user ID
                    if (line.contains("ID Number:" + targetUserId)) {
                        // Check the next line for the password
                        String nextLine = reader.readLine();
                        if (nextLine != null && nextLine.contains("Password:" + targetPassword)) {
                            return true; // ID and password match
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return false; // ID and password do not match or user not found
        }
    }
}


    