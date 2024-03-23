
//import java.util.ArrayList;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ServiceScheduler {
    private Appliance product;
    private String time;
    private String date;
    private Customer customer;
    private Ticket ticket;

    public ServiceScheduler() {
    }

    public ServiceScheduler(Appliance product, String time, String date, Customer customer, Ticket ticket) {
        this.product = product;
        this.time = time;
        this.date = date;
        this.ticket = ticket;
        this.customer = customer;
    }

    public String getTime() {
        return time;
    }

    public Appliance getProduct() {
        return product;
    }

    public String getDate() {
        return date;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // Method to schedule a date for service
    public void scheduleServiceDate(String scheduledDate) {
        this.date = scheduledDate;
        System.out.println("Service scheduled for " + scheduledDate);

        // Replace "schedule.txt" with your actual schedule file path
        String scheduleFilePath = "schedule.txt";

        try {
            // Create or append to the schedule file
            Path path = Paths.get(scheduleFilePath);

            // Build the service schedule information
            String scheduleInfo = "Service scheduled for " + scheduledDate + " for customer: " + customer.getName()
                    + "\n";

            // Write the service schedule information to the file
            Files.write(path, scheduleInfo.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

}
