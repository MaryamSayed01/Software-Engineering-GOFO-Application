/**
 * @author  Maryam Sayed, Gawhara Eid, Nehal hussin
 * @date 5/28/2021 6:42 PM
 */
package GOFO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Files;
public class Player extends User implements Playground{
    /**
     * It contains a default constructor that asks the user
     * either to Registrate or Login
     */
    public Player() {
        int choise;
        System.out.println("1-Signup\n2-LogIn");
        choise=cin.nextInt();
        cin.nextLine();
        if(choise==1) {
            try {
                this.Registrate();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(choise==2){
            this.Login();
        }
    }
    /**
     * It is an override function from  class user
     * It is a function that allows the user to create a new account for him
     */
    @Override
    public void Registrate() throws IOException {
       String name,email,password;
       System.out.println("Enter your full name:");
       name=cin.nextLine();
       System.out.println("Enter your email:");
       email=cin.next();
       System.out.println("Enter unique password avoiding this char'/':");
       password=cin.next();
       while(password.contains("/")){
           System.out.println("Invalid password try again");
           password=cin.next();
       }
       this.name=name;this.password=password;this.email=email;
       String data=this.name+"/"+this.email+"/"+this.password;
       this.addPlayer(data);
    }
    /**
     * This function saves the data of the new player in the player’s file
     * @param data a parameter that holds the data to pass it to the  player’s file
     */
    public void addPlayer(String data)throws IOException {
        try {
            File ownersFile = new File("D:\\FCAI\\2 st Year\\SoftwareEng\\Tasks\\task4Java\\src\\GOFO\\Players'file.txt");
            FileWriter addOwner = new FileWriter(ownersFile, true);
            addOwner.write(data+"\n");
            addOwner.close();
        }catch(Exception e){System.out.println(e.getMessage());}
    }
    /**
     * It is an override function from  class user
     * It is a function that allows the player user to enter his information to access his account
     */
    @Override
    public void Login(){
        String name,email,password;
        System.out.println("Enter your full name:");
        name=cin.nextLine();
        System.out.println("Enter your email:");
        email=cin.next();
        System.out.println("Enter your password :");
        password=cin.next();
        String data=name+"/"+email+"/"+password;
        if(foundMatch(data)){
            System.out.println("Login success");
            this.name=name; this.password=password;this.email=email;
        }else{
            System.out.println("Login failed");
            this.Login();
        }
    }
    /**
     * This function make sure that the user’s have an account
     * and the information are correct
     * @param data a parameter that holds the data of the entered user to check the validation of the data
     * @return if the player user found or not
     */
    public Boolean foundMatch(String data){
        File ownersFile = new File("D:\\FCAI\\2 st Year\\SoftwareEng\\Tasks\\task4Java\\src\\GOFO\\Players'file.txt");
        try (Scanner checkForPlayer = new Scanner(ownersFile)) {
            String pattern;
            while (checkForPlayer.hasNext()) {
                pattern = checkForPlayer.nextLine();
                if (data.equals(pattern)) //if we found the data
                {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
    /**
     * It is a function that has an empty implementation
     * as there is no filtration for requests for the player.
     * @param filterdBy  a parameter for filtration requests
     */
    public void Filter(String filterdBy){}
    /**
     * it's a functions enables the player to search for playground booking offers
     */
    public void SearchPlaygrounds(){}
    /**
     * It is a function that allows the player
     * to choose the offer to book a playground
     */
    public void BookPlayground() throws IOException {
        BooksList();
        int choiseOffer = 0;
        String offerLine;
        System.out.println("\nEnter the offer number you want to book");
        Scanner offersFile = new Scanner("D:\\FCAI\\2 st Year\\SoftwareEng\\Tasks\\task4Java\\src\\GOFO\\Owners'Offers.txt");
        try{
            choiseOffer=cin.nextInt();
            offerLine = Files.readAllLines(Paths.get("D:\\FCAI\\2 st Year\\SoftwareEng\\Tasks\\task4Java\\src\\GOFO\\Owners'Offers.txt")).get(choiseOffer-1);
            System.out.println(offerLine);
            String Request=this.name+" requested: "+offerLine;
            addRequest(Request);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    /**
     * It is a function that saves the requests of the player in the request file.
     * @param request a parameter that holds the request message of the user
     */
    public  void addRequest(String request) {
        try {
            File requestFile = new File("D:\\FCAI\\2 st Year\\SoftwareEng\\Tasks\\task4Java\\src\\GOFO\\Requests.txt");
            FileWriter addRequest = new FileWriter(requestFile, true);
            addRequest.write(request+'\n');
            addRequest.close();
        }catch(Exception e){System.out.println(e.getMessage());}
    }
    /**
     * It is a function that saves the confirmed books
     * in the owner’s offer so that that no conflict occurs.
     */
    public void BooksList(){
        File ownersFile = new File("D:\\FCAI\\2 st Year\\SoftwareEng\\Tasks\\task4Java\\src\\GOFO\\Owners'Offers.txt");
        try (Scanner ownerOffer = new Scanner(ownersFile)) {
            String offer;
            while (ownerOffer.hasNext()) {
                offer = ownerOffer.nextLine();
                System.out.println(offer);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * It is a function that show the status of the booking playground
     * it has an empty implementation as there is no booking for now
     */
    public void BookStatue(){}
    /**
     * It is a function that takes the email of the other players to send them the invitation
     */
    public void InvitePlayers(){}
    /**
     * It is a function that displays the information of the user including his bookings and requests.
     */
    public void ViewProfile(){}
    /**
     * This is an override function from class user
     * This function is not allowed for this user,it prints an invalid message for the user.
     */
    @Override
    public void offerPlayground() throws ParseException {
        System.out.println("Not allowed for you this feature!");
        return;
    }
    /**
     * This is an override function from playground interface
     * This function is not allowed for this user,it prints an invalid message for the user
     * @param offer a parameter that holds the data of the offer to pass it to the its file
     */
    @Override
    public void addOffer(String offer) {
        System.out.println("Not allowed for you this feature!");
        return;
    }
    /**
     * This is an override function from playground interface
     * It has an empty implementation as there is no pending requests for the this user.
     */
    @Override
    public void myRequests() {

    }
}
