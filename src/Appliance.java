import java.util.ArrayList;

public class Appliance {
    private String name;
    private String unitNum; // appliance id number
    private String purchaseDate;
    private String warrantyType;
    //private ArrayList<String> Appliancelist;

    public Appliance() {
    }

    /**
     * Base Person Constructor
     * 
     * @param name
     * @param unitNum
     * @param purchaseDate
     * @param warrantyType
     * 
     */
    public Appliance(String name, String unitNum, String purchaseDate, String warrantyType) {
        this.name = name;
        this.unitNum = unitNum;
        this.purchaseDate = purchaseDate;
        this.warrantyType = warrantyType;
    }

    /**
     * getter for the name attributes
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * getter for the unitNum attributes
     * 
     * @return String
     */
    public String getUnitNum() {
        return unitNum;
    }

    /**
     * getter for the purchaseDate attributes
     * 
     * @return String
     */
    public String getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * getter for the warrantyType attributes
     * 
     * @return String
     */
    public String getWarrantyType() {
        return warrantyType;
    }

    public static void main(String[] args) {
        // Create an ArrayList to store items
        ArrayList<String> Appliancelist = new ArrayList<>();

        // Add items to the ArrayList
        Appliancelist.add("Appliance1");
        Appliancelist.add("Appliance2");
        Appliancelist.add("Appliance3");

        // Print the items in the ArrayList
        System.out.println("Items in the ArrayList:");
        for (String Appliance : Appliancelist) {
            System.out.println(Appliance);
        }
    }
}
