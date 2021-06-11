/**
 * @author Maryam Sayed, Gawhara Eid, Nehal hussin
 * @date 5/28/2021 1:09 PM
 */
package GOFO;

import java.io.*;
import java.util.Scanner;
import java.text.*;
import java.util.Date;
public class Owner extends User implements Playground{
    /**
     * an attribute could be access all over the class
     */
    static int playgroundNumber=1;
    /**
     * It is a parameterized constructor that saves the data of the user.
     * @param name user's name
     * @param email user's email
     * @param password user's password
     */
    public Owner(String name,String email,String password) throws IOException {
        this.name=name; this.email=email;this.password=password;
        String data=this.name+"/"+this.email+"/"+this.password;
        this.addOwner(data);
    }
    /**
     *It is a default constructor that asks the user if
     *he want to login or to Registrate
     */
    public Owner() throws IOException {
        int choise;
        System.out.println("1-Signup\n2-LogIn");
        choise=cin.nextInt();
        cin.nextLine();
        if(choise==1) {
            this.Registrate();
        } else if(choise==2){
            this.Login();
        }
    }

    /**
     * This function is override from class user that allows the user
     * to create a new owner account.
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
        this.addOwner(data);

    }

    /**
     * This function saves the data of the new owner in the owner’s file.
     * @param data a parameter that holds the data to pass it to the owner's file
     */
    public void addOwner(String data) throws IOException {
        try {
            File ownersFile = new File("D:\\FCAI\\2 st Year\\SoftwareEng\\Tasks\\task4Java\\src\\GOFO\\Owners'file.txt");
            FileWriter addOwner = new FileWriter(ownersFile, true);
            addOwner.write(data+'\n');
            addOwner.close();
        }catch(Exception e){System.out.println(e.getMessage());}
    }
    /**
     * It is an override function from class user
     * It is a function that allows the owner user to enter his information to access his account
     */
    @Override
    public void Login(){
        String name,email,password;
        System.out.println("Enter your full name:");
        name=cin.nextLine();
        System.out.println("Enter your email:");
        email=cin.nextLine();
        System.out.println("Enter your password :");
        password=cin.nextLine();
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
     * @return if the owner user found or not
     */
    public Boolean foundMatch(String data){
        File ownersFile = new File("D:\\FCAI\\2 st Year\\SoftwareEng\\Tasks\\task4Java\\src\\GOFO\\Owners'file.txt");
        try (Scanner checkForOwner = new Scanner(ownersFile)) {
            String pattern;
            while (checkForOwner.hasNext()) {

                pattern = checkForOwner.nextLine();
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
     * It is a function that shows the requests of the user
     * It has an empty implementation because there is no requests for the owner
     */
    public void myRequests(){}

    /**
     * It is an override function from playground interface to filter requests
     * it has an empty implementation because there is no filtration for requests for the owner.
     * @param filterdBy a parameter for filtration requests
     */
    @Override
    public void Filter(String filterdBy) {

    }
    /**
     * It is an override function from playground interface
     * This function is not allowed for this user,it prints an invalid message for the user
     */
    @Override
    public void SearchPlaygrounds() {
        System.out.println("Not allowed for you this feature!");
        return;
    }


    /**
     * It is an override function from playground interface
     * This function is not allowed for this user,it prints an invalid message for the user
     */
    @Override
    public void BookPlayground() throws IOException {
        System.out.println("Not allowed for you this feature!");
        return;
    }

    @Override
    public void BooksList() {

    }
    /**
     * It is an override function from playground interface
     * This function is not allowed for this user,it prints an invalid message for the user
     * @param request a parameter that holds the request message of the user
     */
    @Override
    public void addRequest(String request) {
        System.out.println("Not allowed for you this feature!");
        return;
    }

    /**
     * This function allows the owner to add an offer for his playground.
     */
    public  void offerPlayground() throws ParseException {
        String location;
        int pricePerHour;
        String availabeTimeSlots;
        String timeslots;
        System.out.println("Playground location:");
        location=cin.nextLine();

        System.out.println("price per hour");
        pricePerHour=cin.nextInt();
        cin.nextLine();
        System.out.println("available time slots,First:(Enter the time slot[dd-MMM(eg.Dec)-yyyy HH:mm:ss]");
        availabeTimeSlots=cin.nextLine();
        cin.nextLine();
        Date todayDate = new Date();
        SimpleDateFormat formatterDate=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        Date availabeTimeSlotsDate=formatterDate.parse(availabeTimeSlots);

        String offetData=playgroundNumber+"-Owner: "+this.name+",Location:"+location+",Available Slot: "+availabeTimeSlotsDate+",Price per hour:"+pricePerHour+"L.E";
        playgroundNumber++;
        this.addOffer(offetData);
        /*String []timeslots=new String[slotsNumber];
        for(int slot=0;slot<slotsNumber;i++){
            System.out.println("Enter the time of slot number[hh:mm:ss] "+slot+1);
            timeslots[slot]=cin.nextLine();
        }*/
        /*
        Date availableTimeSlotsDate=new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(availabeTimeSlots);
        while(availableTimeSlotsDate.before(todayDate)){
            System.out.println("Invalid todayDate, it's passed todayDate!");
            System.out.println("Enter available time slots,First:(Enter the time slot[dd-MMM-yyyy HH:mm:ss]");
            availabeTimeSlots=cin.nextLine();
            todayDate = new Date();
            availableTimeSlotsDate=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(availabeTimeSlots);
        }*/
    }

    /**
     * This function add the offer and saves it in the offer file.
     * @param offer a parameter that holds the data of the offer to pass it to the offer file
     */
    public void addOffer(String offer){
        try {
            File ownersFile = new File("D:\\FCAI\\2 st Year\\SoftwareEng\\Tasks\\task4Java\\src\\GOFO\\Owners'Offers.txt");
            FileWriter addOffer = new FileWriter(ownersFile, true);
            addOffer.write(offer+"\n");
            addOffer.close();
        }catch(Exception e){System.out.println(e.getMessage());}
    }
}
