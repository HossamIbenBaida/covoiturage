package voiturage.co.com.co_voiturage;

/**
 * Created by ASUS on 26/04/2018.
 */

public class Users {

    private String fname ;
    private  String lname ;
    private  String username ;
    private String email ;
    private String tel ;
    private String addresse ;

    public Users(String fname, String lname, String username, String email, String tel, String addresse) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.email = email;
        this.tel = tel;
        this.addresse = addresse;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }
}
