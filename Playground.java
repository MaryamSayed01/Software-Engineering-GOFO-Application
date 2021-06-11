package GOFO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Scanner;

/**
 * @author Gawhara Eid, Nehal hussin, Maryam Sayed
 * @date 5/30/2021 7:48 AM
 */
public interface Playground {
    /**
     * A function for adding an offer to a playground.
     */
    public  void offerPlayground() throws ParseException;

    /**
     * A function to add the offer of playground and saves it in it's file.
     * @param offer a parameter that holds the data of the offer to pass it to it's file
     */
    public void addOffer(String offer);

    /**
     * A function that shows the requests of the user
     */
    public void myRequests();

    /**
     *  A function that make filtration to requests
     * @param filterdBy a parameter for filtration requests
     */
    public void Filter(String filterdBy);

    /**
     *  A function that allows the user to search for playgrounds
     */
    public void SearchPlaygrounds();

    /**
     * A function that allows the user to book a playground
     */
    public void BookPlayground() throws IOException;


    public void BooksList();

    /**
     * A function that add the request of the user in its file
     * @param request a parameter that holds the request message of the user
     */

    public void addRequest(String request);

}
