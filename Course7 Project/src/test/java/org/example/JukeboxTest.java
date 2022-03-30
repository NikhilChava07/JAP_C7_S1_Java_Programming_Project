package org.example;

import LoginImplementation.LoginImplementation;
import Model.podcasts;
import Model.songs;
import PodcastImplement.PodcastImplement;
import SongImplement.SongsImplement;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class JukeboxTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void LoginCheck() throws SQLException
    {
        boolean b = LoginImplementation.authenticationCheck("Nik123", "nikhil123");
        assertTrue(b);
        boolean a = LoginImplementation.authenticationCheck("nikhil", "nikhil");
        assertFalse(a);
    }
    @Test
    public void displaySongs() throws SQLException
    {
        SongsImplement si =new SongsImplement();
        List<songs> Song= si.songsDisplay();
        assertEquals(10,Song.size());
    }
    @Test
    public void displayPodcasts() throws SQLException
    {
        PodcastImplement pi =new PodcastImplement();
        List<podcasts> Podcast = pi.podcastsDisplay();
        assertEquals(7,Podcast.size());
    }
}