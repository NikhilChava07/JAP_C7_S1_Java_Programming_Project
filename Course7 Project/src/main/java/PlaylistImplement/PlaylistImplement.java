package PlaylistImplement;

import ConnectionCheck.ConnectionCheck;
import IProject.IPlaylists;
import Model.podcasts;
import Model.songs;
import SimpleAudioPlayer.SimpleAudioPlayer;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PlaylistImplement implements IPlaylists {
    public void playlistCreate(String uname) throws SQLException{
        Connection con= ConnectionCheck.getConnection();
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Name of the Playlist(must be unique)");
        String plname=sc.nextLine();
        try {
            PreparedStatement pt = con.prepareStatement("insert into playlistTab(playlistName,userName) values(?,?);");
            pt.setString(1, plname);
            pt.setString(2,uname);
            int rowsaffected = pt.executeUpdate();
            if (rowsaffected != 0) {
                System.out.println("Your PlayList '"+plname+ "' created sucussfully");
            }
            else
                System.out.println("Your playlist was not created");
        } catch (SQLException e) {
            System.out.println("PlayList '"+plname+"' already Exists");
        }
    }
    public void addToPlaylists(String uname, List<songs> song, List<podcasts> podcast) throws SQLException {
        Connection con= ConnectionCheck.getConnection();
        Statement stmt = con.createStatement();
        String querya ="select playlistId,playListName from playlistTab where username='"+uname+"';";
        ResultSet rs = stmt.executeQuery(querya);
        if(!rs.next()){
            System.out.println("No Playlists avilable , Create a new Playlist to add a Song/Podcast");
        }
        else{
            System.out.println("************************************* Your playlists *************************************");
            System.out.format("%-15s%-18s\n","Playlist Id","Playlist Name");
            ResultSet rt = stmt.executeQuery(querya);
            while (rt.next()) {
                System.out.format("%-15s%-18s\n",rt.getString(1),rt.getString(2));
            }
            int pId=0;
            int y;
            do {
                y=0;
                try {
                    Scanner sc= new Scanner(System.in);
                    System.out.println(" Enter the Playlist Id ");
                    pId = sc.nextInt();
                } catch(InputMismatchException e){
                    System.out.println("Enter a valid Playlist Id");
                    y++;
                }
            } while(y!=0);
            Scanner sc= new Scanner(System.in);
            String aType;
            do {
                System.out.println("Press.......\n1 to add a song\n2 to add a podcast");
                aType = sc.next();
            } while(!aType.equalsIgnoreCase("1") && !aType.equalsIgnoreCase("2"));
            String aId="";
            if (aType.equalsIgnoreCase("1")){
                int a=0;
                do {
                    a=0;
                    System.out.println(" Enter the song Id ");
                    aId = sc.next();
                    for(songs s:song) {
                        if(s.getSongId()==Integer.parseInt(aId)){
                            a++;
                        }
                    }
                    if(a!=1){
                        System.out.println("Entered Song ID is ivalid");
                    }
                    Statement sta = con.createStatement();
                    System.out.println("Your playlists");
                    String query ="select * from playlist where audioId='"+aId+"';";
                    ResultSet ra = sta.executeQuery(query);
                    while (ra.next()) {
                        System.out.println("Song already exists");
                        a=0;
                    }
                }while(a!=1);

            }
            else if(aType.equalsIgnoreCase("2")){
                int b=0;
                do {
                    b = 0;
                    System.out.println(" Enter the podcast Id ");
                    aId =sc.next();
                    for(podcasts p:podcast) {
                        if(p.getPodcastId().equalsIgnoreCase(aId)){
                            b++;
                        }
                    }
                    if(b == 0){
                        System.out.println("Entered Podcast ID is ivalid");
                    }
                    Statement sta = con.createStatement();
                    System.out.println("Your playlists");
                    String query ="select * from playlist where audioId='"+aId+"';";
                    ResultSet ra = sta.executeQuery(query);
                    while (ra.next()) {
                        System.out.println("Podcast already exists in the playlist");
                        b=0;
                    }
                }while(b!=1 &&b!=2 &&b!=3);
            }
            try {
                PreparedStatement pt = con.prepareStatement("insert into playlist values(?,?,?);");
                pt.setInt(1, pId);
                pt.setString(2,aType);
                pt.setString(3,aId);
                int rowsaffected = pt.executeUpdate();
                if (rowsaffected != 0) {
                    System.out.println("songs/podcasts added sucussfully");
                }
                else
                    System.out.println("songs/podcasts not added");
            } catch (SQLException e) {
                System.out.println("Playlist Id entered is Invalid");
            }
        }
    }
    public void DisplayContents(String uname, List<songs> song, List<podcasts> podcast) throws SQLException {
        Connection con= ConnectionCheck.getConnection();
        Statement sta = con.createStatement();
        String querya ="select playlistId,playListName from playlistTab where username='"+uname+"';";
        ResultSet ra = sta.executeQuery(querya);
        if(!ra.next()){
            System.out.println("No PlayLists available");
        }
        else{
            System.out.println("************************************* Your playlists *************************************");
            ResultSet rm = sta.executeQuery(querya);
            System.out.format("%-15s%-18s\n","Playlist Id","Playlist Name");
            while (rm.next()) {
                System.out.format("%-15s%-18s\n",rm.getString(1),rm.getString(2));
            }
            int pId=0;
            int y=0;
            do {
                y=0;
                try {
                    Scanner sc= new Scanner(System.in);
                    System.out.println("Enter the Playlist ID");
                    pId = sc.nextInt();
                } catch(InputMismatchException e){
                    System.out.println("Not a valid Playlist Id");
                    y++;
                }
            } while(y!=0);
            int z=0;
            ResultSet rn = sta.executeQuery(querya);
            while (rn.next()) {
                if(rn.getInt(1)==pId)
                z++;
            }
            if(z==0){
                System.out.println("PlayList does not exist");
            }
            else{
            System.out.println("Contents in PlayList");
            Statement stmt = con.createStatement();
            String queryb="select * from playlist where playlistId='"+pId+"';";
            ResultSet rs = stmt.executeQuery(queryb);
            while(rs.next()) {
                if (rs.getString(2).equalsIgnoreCase("1")) {
                    for(songs s: song){
                        if(s.getSongId()==Integer.parseInt(rs.getString(3)))
                            System.out.println(s);
                    }
                }
                else if (rs.getString(2).equalsIgnoreCase("2")) {
                    for(podcasts p: podcast){
                        if(p.getPodcastId().equalsIgnoreCase(rs.getString(3)))
                            System.out.println(p);
                    }
                }
            }
            }
        }
    }

    public void playPlaylist(String uname, List<songs> song, List<podcasts> podcast) throws Exception {
        Connection con= ConnectionCheck.getConnection();
        Statement sta = con.createStatement();
        String querya ="select playlistId,playListName from playlistTab where username='"+uname+"';";
        ResultSet ra = sta.executeQuery(querya);
        if(!ra.next()){
            System.out.println("No PlayLists available");
        }
        else {
            System.out.println("************************************* Your playlists *************************************");
            ResultSet rm = sta.executeQuery(querya);
            System.out.format("%-15s%-18s\n", "Playlist Id", "Playlist Name");
            while (rm.next()) {
                System.out.format("%-15s%-18s\n", rm.getString(1), rm.getString(2));
            }
        }
        int pId=0;
        int y=0;
        do {
            y=0;
            try {
                Scanner sc= new Scanner(System.in);
                System.out.println("Enter the Playlist ID");
                pId = sc.nextInt();
            } catch(InputMismatchException e){
                System.out.println("Not a valid Playlist Id");
                y++;
            }
        } while(y!=0);
        int z=0;
        ResultSet rn = sta.executeQuery(querya);
        while (rn.next()) {
            if(rn.getInt(1)==pId){
                z++;
            }
        }
        if(z==0){
            System.out.println("PlayList does not exist");
        }
        else{
            Statement str = con.createStatement();
            String queryb ="select * from playlist where playlistId='"+pId+"';";
            ResultSet rw = str.executeQuery(queryb);
            if(!rw.next()){
             System.out.println("Playlist is empty");
            }
            ResultSet rq = str.executeQuery(queryb);
            while(rq.next()){
                if(rq.getString(2).equalsIgnoreCase("1"))
                {
                    for(songs s: song) {
                        if (s.getSongId() == Integer.parseInt(rq.getString(3))){
                            System.out.println("Playing "+s.getSongName()+" Song from "+pId+" playlist");
                            SimpleAudioPlayer.Ncjukebox(s.getSource(), "song");
                        }
                    }
                }
                else if(rq.getString(2).equalsIgnoreCase("2")){
                    for(podcasts s: podcast) {
                        if (s.getPodcastId().equalsIgnoreCase(rq.getString(3))){
                            System.out.println("Playing "+s.getEpisodeName()+" Episode from "+pId+" playlist");
                            SimpleAudioPlayer.Ncjukebox(s.geteSource(), "podcast");
                        }
                    }
                }
            }
        }
    }
}