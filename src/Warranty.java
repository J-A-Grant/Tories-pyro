public class Warranty {
    private String wname;
    private Float wcost;
    private String duration;
    private String status;
    private String details;
 
    public Warranty() {
    }
 
    public Warranty(String wname, Float wcost, String duration, String status, String details) {
        this.wname = wname;
        this.wcost = wcost;
        this.duration = duration;
        this.status = status;
        this.details = details;
    }
 
    public String getWName() {
        return this.wname;
    }
 
    public String getDuration() {
        return this.duration;
    }
 
    public String getStatus() {
        
        return this.status;
    }
 
    public String getDetail() {
        return this.details;
    }
 
    public Float getCost() {
        return this.wcost;
    }
 
    public Float calcWarranty() {
        if ("reg1".equals(this.wname)) {
            this.duration = "1 year";
            this.wcost = 100.0f; // Set the actual cost for reg1
        } else if ("reg2".equals(this.wname)) {
            this.duration = "1 year";
            this.wcost = 150.0f; // Set the actual cost for reg2
        } else if ("prem1".equals(this.wname)) {
            this.duration = "3 years";
            this.wcost = 200.0f; // Set the actual cost for prem1
        } else if ("prem2".equals(this.wname)) {
            this.duration = "3 years";
            this.wcost = 250.0f; // Set the actual cost for prem2
        }
 
        return this.wcost;
    }
 }
 