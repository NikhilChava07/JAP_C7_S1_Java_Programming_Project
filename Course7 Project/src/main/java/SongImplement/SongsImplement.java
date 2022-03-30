package SongImplement;
import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import ConnectionCheck.ConnectionCheck;
import IProject.ISongs;
import Model.songs;

public class SongsImplement implements ISongs {
    List<songs> Song = new ArrayList<>();
    public List<songs> songsDisplay() throws SQLException {
        Connection con=ConnectionCheck.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from songs");
        System.out.format("%-9s%-18s%-20s%-12s%-22s%-15s%-15s\n","Song Id","Song","Artist","Duration","Album Name","Genre","Location");
        while (rs.next()) {
            System.out.format("%-9s%-18s%-20s%-12s%-22s%-15s%-15s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
            songs s = new songs();
            s.setSongId(rs.getInt(1));
            s.setSongName(rs.getString(2));
            s.setArtist(rs.getString(3));
            s.setDuration(rs.getString(4));
            s.setAlbumName(rs.getString(5));
            s.setGenre(rs.getString(6));
            s.setSource(rs.getString(7));
            Song.add(s);
        }
        return Song;
    }
    public void searchedSongs() throws SQLException {
        //Connection con= ConnectionCheck.getConnection();
        //Statement stmt = con.createStatement();
        System.out.println("Enter the song Name / Artist / Album name to be searched");
        Scanner sc= new Scanner(System.in);
        String SongDetail=sc.nextLine();
        /*String Query ="select * from songs WHERE songName='"+SongDetail+"' OR artist='"+SongDetail+"' OR albumName='"+SongDetail+"' Order by songName Asc;";
        ResultSet rs = stmt.executeQuery(Query);
        else {
            System.out.format("%-9s%-18s%-20s%-12s%-22s%-15s%-15s\n", "Song Id", "Song", "Artist", "Duration", "Album Name", "Genre", "Location");
            while (rs.next()) {
                System.out.format("%-9s%-18s%-20s%-12s%-22s%-15s%-15s\n", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        }*/
        List<songs> S =Song.stream().filter(p->p.getArtist().equalsIgnoreCase(SongDetail) || p.getAlbumName().equalsIgnoreCase(SongDetail) ||p.getSongName().equalsIgnoreCase(SongDetail)).sorted(Comparator.comparing(songs::getSongName)).collect(Collectors.toList());
        if(S.size()==0){
            System.out.println("No results found");
        }
        else{
        System.out.format("%-9s%-18s%-20s%-12s%-22s%-15s%-15s\n", "Song Id", "Song", "Artist", "Duration", "Album Name", "Genre", "Location");
        S.forEach(i->System.out.format("%-9s%-18s%-20s%-12s%-22s%-15s%-15s\n",i.getSongId(),i.getSongName(),i.getArtist(),i.getDuration(),i.getAlbumName(),i.getGenre(),i.getSource()));
        }
    }
}