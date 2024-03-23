
public class Ticket {
    private String title ;
    private String name;
    private int ticketNumber;
    private String priority;
    private String description;
    private String contactInfo;
    private String status;

    public Ticket() {}
    
    /**
     * Base Person Constructor
     * @param title
     * @param ticketNumber
     * @param name
     * @param priority
     * @param description
     * @param contactInfo
     * @param status
     */
    public Ticket(int ticketNumber,String title,  String name,String contactInfo,String description,String priority,  String status) {
        this.ticketNumber= ticketNumber;
        this.title = title;
        this.name = name;
        this.contactInfo= contactInfo;
        this.description  = description;
        this.priority= priority;
        this.status= status;
    }

    /**
    *  getter for the name attributes
    * @return String
    */
    public String getName() {
        return name;
    }

    /**
    *  getter for the title attributes
    * @return String
    */
    public String getTitle() {
        return title;
    }

    /**
    *  getter for the status attributes
    * @return String
    */
    public String getStatus() {
        return status;
    }

    /**
    *  setter for the status attributes
    * @return String
    */
    public String setStatus(String status) {
        return this.status = status;
    }
    
    /**
    *  getter for the priority attributes
    * @return String
    */
    public String getPriority() {
        return priority;
    }

    /**
    *  getter for the description attributes
    * @return String
    */
    public String getDescription() {
        return description;
    }
    
    /**
    *  getter for the contactInfo attributes
    * @return String
    */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
    *  getter for the ticketNumber attributes
    * @return String
    */
    public int getTicketNumber() {
        return ticketNumber;
    }

    public String toString(){
        return this.getTicketNumber() +"," +this.getTitle()+","+this.getName()+","+this.getContactInfo()
        +","+this.getDescription()+","+this.getPriority() +","+this.getStatus();
    }

       // Method to set the ticket number
    public void setTicketNumber(int number) {
        this.ticketNumber = number;
    }

}
