package Entities;

public class UserCar {

    private String Username;
    private String Password;
    private String Email;
    private String Date;
    private Double Phone;
    private String Note;
    private int User_roles;
    private String User_fullname;
    private int User_id;


    public UserCar() {
    }

    public UserCar(int id) {
        User_id=id;
    }

    public UserCar(String username, String password, String email, String date, double phone, String note, int user_roles, String user_fullname, int user_id) {
        Username = username;
        Password = password;
        Email = email;
        Date = date;
        Phone = phone;
        Note = note;
        User_roles = user_roles;
        User_fullname = user_fullname;
        User_id = user_id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Double getPhone() {
        return Phone;
    }

    public void setPhone(Double phone) {
        Phone = phone;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public int getUser_roles() {
        return User_roles;
    }

    public void setUser_roles(int user_roles) {
        User_roles = user_roles;
    }

    public String getUser_fullname() {
        return User_fullname;
    }

    public void setUser_fullname(String user_fullname) {
        User_fullname = user_fullname;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }
}
