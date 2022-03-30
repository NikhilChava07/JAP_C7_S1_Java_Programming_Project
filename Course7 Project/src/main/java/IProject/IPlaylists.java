package IProject;

import Model.podcasts;
import Model.songs;

import java.sql.SQLException;
import java.util.List;

public interface IPlaylists {
    public void playlistCreate(String uname) throws SQLException ;
    public void addToPlaylists(String uname, List<songs> song, List<podcasts> podcast) throws SQLException;
    public void DisplayContents(String uname, List<songs> song, List<podcasts> podcast) throws SQLException;
}