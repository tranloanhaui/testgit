package Entities;

public class Customer {
    private String Customer_id;
    private int Customer_phone;
    private String Customer_name;
    private String Customer_fullname;
    private String Customer_birthday;
    private Double Customer_homephone;
    private String Customer_email;
    private String Customer_address;
    private String Customer_job;
    private String Customer_note;
    private String Customer_roles;

    public Customer() {
    }
    public Customer(String customer_id){
        this.Customer_id=customer_id;
    }
    public Customer(String customer_id, int customer_phone, String customer_name, String customer_fullname, String customer_birthday, Double customer_homephone, String customer_email, String customer_address, String customer_job, String customer_note, String customer_roles) {
        Customer_id = customer_id;
        Customer_phone = customer_phone;
        Customer_name = customer_name;
        Customer_fullname = customer_fullname;
        Customer_birthday = customer_birthday;
        Customer_homephone = customer_homephone;
        Customer_email = customer_email;
        Customer_address = customer_address;
        Customer_job = customer_job;
        Customer_note = customer_note;
        Customer_roles = customer_roles;
    }

    public String getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(String customer_id) {
        Customer_id = customer_id;
    }

    public int getCustomer_phone() {
        return Customer_phone;
    }

    public void setCustomer_phone(int customer_phone) {
        Customer_phone = customer_phone;
    }

    public String getCustomer_name() {
        return Customer_name;
    }

    public void setCustomer_name(String customer_name) {
        Customer_name = customer_name;
    }

    public String getCustomer_fullname() {
        return Customer_fullname;
    }

    public void setCustomer_fullname(String customer_fullname) {
        Customer_fullname = customer_fullname;
    }

    public String getCustomer_birthday() {
        return Customer_birthday;
    }

    public void setCustomer_birthday(String customer_birthday) {
        Customer_birthday = customer_birthday;
    }

    public Double getCustomer_homephone() {
        return Customer_homephone;
    }

    public void setCustomer_homephone(Double customer_homephone) {
        Customer_homephone = customer_homephone;
    }

    public String getCustomer_email() {
        return Customer_email;
    }

    public void setCustomer_email(String customer_email) {
        Customer_email = customer_email;
    }

    public String getCustomer_address() {
        return Customer_address;
    }

    public void setCustomer_address(String customer_address) {
        Customer_address = customer_address;
    }

    public String getCustomer_job() {
        return Customer_job;
    }

    public void setCustomer_job(String customer_job) {
        Customer_job = customer_job;
    }

    public String getCustomer_note() {
        return Customer_note;
    }

    public void setCustomer_note(String customer_note) {
        Customer_note = customer_note;
    }

    public String getCustomer_roles() {
        return Customer_roles;
    }

    public void setCustomer_roles(String customer_roles) {
        Customer_roles = customer_roles;
    }
}
