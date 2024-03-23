

public class BasePerson {

    private String name;
    private String telephone;
    private String email;
    private String password;
   
    public BasePerson() {}
    
    /**
     * Base Person Constructor
     * @param name
     * @param telephone
     * @param email
     * @param password
     */
    public BasePerson(String name, String telephone, String email, String password) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
    }

     public BasePerson(String password) {
    
        this.password = password;
    }
         
    /** 
    *  getter for the name attributes
    * @return String
    */
    public String getName() {
        return name;
    }

    
   /** 
    *  getter for the telephone attributes
    * @return String
    */
    public String getTelephone() {
        return telephone;
    }

     /** 
    *  getter for the email attributes
    * @return String
    */
    public String getEmail() {
        return email;
    }

    /** 
    *  getter for the password attributes
    * @return String
    */
    public String getPassword() {
        return password;
    }
}
