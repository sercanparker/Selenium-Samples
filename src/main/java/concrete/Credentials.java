package concrete;

/**
 * @author sercansensulun on 30.05.2020.
 */
public class Credentials {

    private String username;
    private String password;
    private String email;


    public Credentials(String email, String password, String username) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
