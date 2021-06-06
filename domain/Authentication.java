package domain;
/**
 * @author Krutika Mohanty
 * Authentication module for NetFin
 */
public class Authentication {
    private String user;
    private String password;

    public Authentication(String user, String password){
        this.user = user;
        this.password = password;
    }

    /**
     * Used for matching user entered pasword with database value.
     * @param password
     * @return
     */
    public boolean match(String userName, String password){
        if(this.user.equals(userName) && 
            this.password.equals(password)){
            return true;
        }
        return false;
    }

    /**
     * There is no need of get user name
     */
    /*public String getUser() {
        return user;
    }*/
    public void setUser(String user) {
        this.user = user;
    }
    /**
     * There is no need to get password, as it should never be printed
     * A password should only be matched.
    */
    /*public String getPassword() {
        return password;
    }*/
    public void setPassword(String password) {
        this.password = password;
    }

    

    
}
