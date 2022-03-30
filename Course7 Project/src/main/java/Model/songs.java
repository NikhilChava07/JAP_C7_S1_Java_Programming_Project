package Model;

public class songs {
    private int songId;
    private String songName;

    public songs() {
    }

    private String artist;
    private String duration;
    private String albumName;
    private String genre;
    private String source;

    public songs(int songId, String songName, String artist, String duration, String albumName, String genre, String source) {
        this.songId = songId;
        this.songName = songName;
        this.artist = artist;
        this.duration = duration;
        this.albumName = albumName;
        this.genre = genre;
        this.source = source;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Song Id= " + songId +
                ", Song Name= '" + songName + '\'' +
                ", Artist= '" + artist + '\'' +
                ", duration= '" + duration + '\'' +
                ", Album Name= '" + albumName + '\'' +
                ", Genre= '" + genre + '\'' +
                ", Source= '" + source + '\''+"";
    }
}
