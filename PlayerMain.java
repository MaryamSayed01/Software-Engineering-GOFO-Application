package GOFO;

import java.io.IOException;
import java.text.ParseException;

/**
 * @author Maryam Sayed,  Gawhara Eid, Nehal hussin
 * @date 5/29/2021 12:12 PM
 */
public class PlayerMain {
    public static void main(String args[]) throws IOException, ParseException {
        Player player=new Player();
        System.out.println("Start book a playground\n");
        player.BookPlayground();
    }
}
