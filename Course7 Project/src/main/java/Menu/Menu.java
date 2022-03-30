package Menu;
import ProjectException.ProjectException;

import java.util.*;
public class Menu {
    public static String getmenu() {
        String choice="";
        System.out.println("\n1 to search a song \n2 to search a podcast\n3 to Create a Playlist\n4 to add a song/podcast to an existing Playlist \n5 to view Playlist contents\n6 to Play a Specific Song\n7 to Play a Specific Podcast Episode\n8 to Play a playlist\n9 to exit");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter choice: ");
            choice = sc.next();
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6") && !choice.equals("7") && !choice.equals("8") && !choice.equals("9"));
        return choice;
    }
}