package Model;

public class podcasts {
    private String podcastId ;
    private String podcastName;
    private String episodeId;
    private String episodeName;
    private String eArtist;
    private String eDuration;
    private String eDate;
    private String eSource;

    public podcasts() {
    }

    public podcasts(String podcastId, String podcastName, String episodeId, String episodeName, String eArtist, String eDuration, String eDate, String eSource) {
        this.podcastId = podcastId;
        this.podcastName = podcastName;
        this.episodeId = episodeId;
        this.episodeName = episodeName;
        this.eArtist = eArtist;
        this.eDuration = eDuration;
        this.eDate = eDate;
        this.eSource = eSource;
    }

    public String getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(String podcastId) {
        this.podcastId = podcastId;
    }

    public String getPodcastName() {
        return podcastName;
    }

    public void setPodcastName(String podcastName) {
        this.podcastName = podcastName;
    }

    public String getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(String episodeId) {
        this.episodeId = episodeId;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public String geteArtist() {
        return eArtist;
    }

    public void seteArtist(String eArtist) {
        this.eArtist = eArtist;
    }

    public String geteDuration() {
        return eDuration;
    }

    public void seteDuration(String eDuration) {
        this.eDuration = eDuration;
    }

    public String geteDate() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate = eDate;
    }

    public String geteSource() {
        return eSource;
    }

    public void seteSource(String eSource) {
        this.eSource = eSource;
    }

    @Override
    public String toString() {
        return "Podcast Id= '" + podcastId + '\'' +
                ", Podcast Name= '" + podcastName + '\'' +
                ", Episode Id= '" + episodeId + '\'' +
                ", Episode Name= '" + episodeName + '\'' +
                ", Celebrity= '" + eArtist + '\'' +
                ", Duration= '" + eDuration + '\'' +
                ", Date Published= '" + eDate + '\'' +
                ", Source= '" + eSource + '\''+"";
    }
}
