package IProject;
import Model.songs;

import java.sql.SQLException;
import java.util.List;

public interface ISongs {
    public List<songs> songsDisplay() throws SQLException;
    public void searchedSongs() throws SQLException;
}

