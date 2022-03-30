package PodcastImplement;

import ConnectionCheck.ConnectionCheck;
import IProject.IPodcasts;
import Model.podcasts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PodcastImplement implements IPodcasts {
    List<podcasts> Podcast = new ArrayList<>();
    public List<podcasts> podcastsDisplay() throws SQLException {
        Connection con= ConnectionCheck.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from podcasts");
        System.out.format("%-12s%-18s%-12s%-30s%-17s%-15s%-18s%-15s\n","Podcast Id","Podcast name","Episode Id","Episode Name","Celebrity","Duration","Date Published","Location");
        while (rs.next()) {
            System.out.format("%-12s%-18s%-12s%-30s%-17s%-15s%-18s%-15s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
            podcasts p = new podcasts();
            p.setPodcastId(rs.getString(1));
            p.setPodcastName(rs.getString(2));
            p.setEpisodeId(rs.getString(3));
            p.setEpisodeName(rs.getString(4));
            p.seteArtist(rs.getString(5));
            p.seteDuration(rs.getString(6));
            p.seteDate(rs.getString(7));
            p.seteSource(rs.getString(8));
            Podcast.add(p);
        }
        return Podcast;
    }
    public void searchedPodcasts() throws SQLException {
        Connection con= ConnectionCheck.getConnection();
        Statement stmt = con.createStatement();
        System.out.println("Enter the Celebrity / Podcast released Date(DD/MM/YYYY) name to be searched");
        Scanner sc= new Scanner(System.in);
        String PodcastDetail=sc.nextLine();
       // String Query ="select * from podcasts WHERE celebrity='"+PodcastDetail+"' OR datePublished='"+PodcastDetail+"' Order by podcastName Asc;";
       // ResultSet rs = stmt.executeQuery(Query);
       // while (rs.next()) {
        //    System.out.format("%-12s%-18s%-12s%-30s%-17s%-15s%-18s%-15s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
       // }
       List<podcasts> pc= Podcast.stream().filter(p->p.geteArtist().equalsIgnoreCase(PodcastDetail)||p.geteDate().equalsIgnoreCase(PodcastDetail)).sorted(Comparator.comparing(podcasts::getEpisodeName)).collect(Collectors.toList());
       if(pc.size()==0){
           System.out.println("No results found");
       }
       else{
           System.out.format("%-12s%-18s%-12s%-30s%-17s%-15s%-18s%-15s\n","Podcast Id","Podcast name","Episode Id","Episode Name","Celebrity","Duration","Date Published","Location");
           pc.stream().forEach(i->System.out.format("%-12s%-18s%-30s%-17s%-15s%-18s%-15s\n",i.getPodcastId(),i.getPodcastName(),i.getEpisodeId(),i.getEpisodeName(),i.geteArtist(),i.geteDuration(),i.geteDate(),i.geteSource()));
       }
    }
}