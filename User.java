package GOFO;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author  Maryam Sayed, Gawhara Eid, Nehal hussin
 * @date 5/28/2021 8:09 PM
 */
public class User {
    public String name;
    public String password;
    public String email;
    private int creditCardNmuber;
    private int  creditCardPassword;
    Scanner cin=new Scanner(System.in);
    /**
     * It is a function for getting the name of the user
     * @return name of the user
     */
    public String getName() {
        return name;
    }
    /**
     * It is a function used for getting the password of the user
     * @return password of the user
     */

    public String getPassword() {
        return password;
    }
    /**
     * It is a function used for getting the Email of the user
     * @return email of the user
     */
    public String getEmail() {
        return email;
    }
    /**
     * It is a function used for getting the CridtCardNmuber of the user
     * @return CridtCardNmuber of the user
     */

    public int getCridtCardNmuber() {
        return creditCardNmuber;
    }
    /**
     * It is a function used for getting the CridtCardPassword of the user
     * @return CridtCardPassword of the user
     */
    public int getCridtCardPassword() {
        return creditCardPassword;
    }
    /**
     * It is a function used to set the name of the user
     * @param name user's name
     */

    public void setName(String name) {
        this.name = name;
    }
    /**
     * It is a function used to set the password of the user
     * @param password user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * It is a function used to set the Email of the user
     * @param email user's email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * It is a function used to set the CridtCardNmuber of the user
     * @param cridtCardNmuber user's CridtCardNmuber
     */
    public void setCridtCardNmuber(int cridtCardNmuber) {
        this.creditCardNmuber = cridtCardNmuber;
    }
    /**
     * It is a function used to set the CridtCardPassword of the user
     * @param cridtCardPassword  user's CridtCardPassword
     */
    public void setCridtCardPassword(int cridtCardPassword) {
        this.creditCardPassword = cridtCardPassword;
    }
    /**
     * It is a function used to allow an older user to access his account
     */
    public void Login(){}
    /**
     * It is a function used to allow a new user  to create a new account for him
     */
    public void Registrate () throws IOException {}

}
