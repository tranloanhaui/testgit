package Entity;

public class UserCar {

    private String username;
    private String password;
    private String Email;

    public UserCar() {
    }

    public UserCar(String username, String password, String email) {
        this.username = username;
        this.password = password;
        Email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
