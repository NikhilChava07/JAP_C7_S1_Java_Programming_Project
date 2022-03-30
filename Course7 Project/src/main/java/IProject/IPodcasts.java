package IProject;

import Model.podcasts;

import java.sql.SQLException;
import java.util.List;

public interface IPodcasts {
    public List<podcasts> podcastsDisplay() throws SQLException;
    public void searchedPodcasts() throws SQLException;
}
