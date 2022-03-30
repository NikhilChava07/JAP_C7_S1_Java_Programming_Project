package Jukebox;

import ConnectionCheck.ConnectionCheck;
import Model.podcasts;
import Model.songs;
import PlaylistImplement.PlaylistImplement;
import PodcastImplement.PodcastImplement;
import SimpleAudioPlayer.SimpleAudioPlayer;
import SongImplement.SongsImplement;
import LoginImplementation.LoginImplementation;
import Menu.Menu;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class Jukebox {
    public static void main(String[] args) throws Exception {
        String Euser;
        System.out.println("************************************** Welcome to NC Jukebox **************************************");
        // Code to test the login credentials if the account exist & to create a new account if not
        do {
            System.out.println("Are you an Existing User ? (Yes/No)");
            Scanner sc = new Scanner(System.in);
            Euser = sc.next();
            if (Euser.equalsIgnoreCase("No")) {
                LoginImplementation.createAccount();
            }
        } while (!Euser.equalsIgnoreCase("Yes") && !Euser.equalsIgnoreCase("No"));
        System.out.println("************************************** Login **************************************\n\n");
        boolean b;
        String username;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Your User Name");
            username = sc.next();
            System.out.println("Enter Your Password");
            String password = sc.next();
            b = LoginImplementation.authenticationCheck(username, password);
            if (!b)
                System.out.println(" Ivalid Username and Password");
        } while (!b);
        System.out.println("************************************** Login Successful **************************************");
        // Code to Call the display songs method and display all the songs to the user
        System.out.println("\n \uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5" +
                "\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5" +
                "\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5 " +
                "Trending Songs \uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5" +
                "\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C" +
                "\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5");
        SongsImplement si = new SongsImplement();
        List<songs> Song = si.songsDisplay();
        System.out.println("\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5");
        System.out.println("\n\n\n \uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5" +
                "\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5" +
                "\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5 " +
                "Trending Podcasts \uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5" +
                "\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C" +
                "\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5");
        // Code to Call the display podcasts method and display all the podcasts to the user
        PodcastImplement pi = new PodcastImplement();
        List<podcasts> Podcast = pi.podcastsDisplay();
        System.out.println("\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5");
        PlaylistImplement pl = new PlaylistImplement();
        // if....elseif....else....opeartors to perform the task given by the user
        String choice;
        do {
            // choice is returned from menu function
            choice = Menu.getmenu();
            if (choice.equals("1")) {
                si.searchedSongs();//calling the method to display all songs
            } else if (choice.equals("2")) {
                pi.searchedPodcasts();//calling the method to display all podcasts
            } else if (choice.equals("3")) {
                pl.playlistCreate(username);//calling the method to create a new playlist
            } else if (choice.equals("4")) {
                pl.addToPlaylists(username, Song, Podcast);//calling the method to add a song/podcast to the specified playlist
            } else if (choice.equals("5")) {
                pl.DisplayContents(username, Song, Podcast);//calling the method to display the contents in a specified playlist
            } else if (choice.equals("6")) {
                String a = "";
                do {
                    System.out.println("Enter a valid Song Id ");
                    Scanner sc = new Scanner(System.in);
                    a = sc.next();
                } while (!a.equals("1") && !a.equals("2") && !a.equals("3") && !a.equals("4") && !a.equals("5") && !a.equals("6") && !a.equals("7") && !a.equals("8") && !a.equals("9") && !a.equals("10"));
                String c = "";
                int h = Integer.parseInt(a);
                Connection con = ConnectionCheck.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from songs");
                while (rs.next()) {
                    if (h == rs.getInt(1))
                        c = rs.getString(7);
                }
                SimpleAudioPlayer.Ncjukebox(c, "song");// this method takes the song path as input parameter & plays the song
            } else if (choice.equals("7")) {
                String a = "";
                do {
                    System.out.println("Enter a valid Podcast Id ");
                    Scanner sc = new Scanner(System.in);
                    a = sc.next();
                } while (!a.equalsIgnoreCase("P1") && !a.equalsIgnoreCase("P2") && !a.equalsIgnoreCase("P3"));
                String d = "";
                do {
                    System.out.println("Enter a valid Episode Id ");
                    Scanner sc = new Scanner(System.in);
                    d = sc.next();
                } while (!d.equalsIgnoreCase("E1") && !d.equalsIgnoreCase("E2") && !d.equalsIgnoreCase("E3"));
                String c = "";
                try {
                    Connection con = ConnectionCheck.getConnection();
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from podcasts");
                    while (rs.next()) {
                        if (a.equalsIgnoreCase(rs.getString(1)) && d.equalsIgnoreCase(rs.getString(3)))
                            c = rs.getString(8);
                    }
                    SimpleAudioPlayer.Ncjukebox(c, "Podcast");
                } catch (FileNotFoundException e) {
                    System.out.println("Episode doesn't exist");// this method takes the podcast path as input parameter & plays the episode
                }
            } else if (choice.equals("8")) {
                Scanner sc = new Scanner(System.in);
                System.out.println("1 to play all songs and podcasts from specific playlist\n2 to play a specific song or podcast from the playlist");
                System.out.println("\nEnter choice : ");
                String response = sc.next();
                if (response.equalsIgnoreCase("1")) {
                    pl.playPlaylist(username, Song, Podcast);//calling the method to play from playsits
                } else if (response.equalsIgnoreCase("2")) {
                    Connection con = ConnectionCheck.getConnection();
                    Statement sta = con.createStatement();
                    String querya = "select playlistId,playListName from playlistTab where username='" + username + "';";
                    ResultSet ra = sta.executeQuery(querya);
                    if (!ra.next()) {
                        System.out.println("No PlayLists available");
                    } else {
                        System.out.println("************************************* Your playlists *************************************");
                        ResultSet rm = sta.executeQuery(querya);
                        System.out.format("%-15s%-18s\n", "Playlist Id", "Playlist Name");
                        while (rm.next()) {
                            System.out.format("%-15s%-18s\n", rm.getString(1), rm.getString(2));
                        }
                    }
                    int pId = 0;
                    int y = 0;
                    do {
                        y = 0;
                        try {
                            System.out.println("Enter the Playlist ID");
                            pId = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Not a valid Playlist Id");
                            y++;
                        }
                    } while (y != 0);
                    int z = 0;
                    ResultSet rn = sta.executeQuery(querya);
                    while (rn.next()) {
                        if(rn.getInt(1)==pId){
                            z++;
                        }
                    }
                    if (z == 0) {
                        System.out.println("PlayList does not exist");
                    } else {
                        String aType;
                        do {
                            System.out.println("\n1 to play a song\n2 to play a podcast");
                            System.out.println("\nEnter choice : ");
                            aType = sc.next();
                        } while (!aType.equalsIgnoreCase("1") && !aType.equalsIgnoreCase("2"));
                        String aId = "";
                        if (aType.equalsIgnoreCase("1")) {
                            int a = 0;
                            do {
                                a = 0;
                                System.out.println(" Enter the song Id ");
                                aId = sc.next();
                                for (songs s : Song) {
                                    if (s.getSongId() == Integer.parseInt(aId)) {
                                        a++;
                                    }
                                }
                                if (a!= 1) {
                                    System.out.println("Entered Song ID is ivalid");
                                }
                                Statement sta1 = con.createStatement();
                                String query = "select * from playlist where playlistId=" + pId + " and audioId='" + aId +"';";
                                ResultSet ra1 = sta1.executeQuery(query);
                                while (ra1.next()) {
                                    for (songs s : Song) {
                                        if (s.getSongId() == Integer.parseInt(ra1.getString(3))){
                                            System.out.println("Playing "+s.getSongName()+" Song from "+pId+" playlist");
                                            SimpleAudioPlayer.Ncjukebox(s.getSource(), "song");
                                        }
                                    }
                                    a = 1;
                                }
                                ResultSet rax = sta1.executeQuery(query);
                                if(!rax.next()){
                                    System.out.println("Song is not in the playlist");
                                }
                            } while (a != 1);
                        } else if (aType.equalsIgnoreCase("2")) {
                            int q = 0;
                            do {
                                q = 0;
                                System.out.println(" Enter the podcast Id ");
                                aId = sc.next();
                                for (podcasts p : Podcast) {
                                    if (p.getPodcastId().equalsIgnoreCase(aId)) {
                                        q++;
                                    }
                                }
                                if (q == 0) {
                                    System.out.println("Entered Podcast ID is ivalid");
                                }
                                Statement sta2 = con.createStatement();
                                String query = "select * from playlist where playlistId=" + pId + " and audioId='" + aId + "';";
                                ResultSet ra2 = sta2.executeQuery(query);
                                while (ra2.next()) {
                                    for (podcasts s : Podcast) {
                                        if (s.getPodcastId().equalsIgnoreCase(ra2.getString(3))){
                                            System.out.println("Playing "+s.getEpisodeName()+" Episode from "+pId+" playlist");
                                            SimpleAudioPlayer.Ncjukebox(s.geteSource(), "podcast");
                                        }
                                    }
                                    q = 1;
                                }
                                ResultSet ray = sta2.executeQuery(query);
                                if(!ray.next()){
                                    System.out.println("Podcast is not in the playlist");
                                }
                            } while (q != 1 && q != 2 && q != 3);
                        }
                    }
                }
                else {
                    System.out.println("Wrong choice entered");
                }
            } else {
                System.out.println("\n \uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5" +
                        "\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5" +
                        "\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5 " +
                        "Thank You \uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5" +
                        "\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C" +
                        "\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5\uD83C\uDFB5");
            }
        } while (!choice.equals("9"));
    }
}