package codegym.model;

public class Music {
    String name;
    String singer;
    String kindOfMusic;
    String link;

    public Music() {
    }

    public Music( String name, String singer, String kindOfMusic, String link) {

        this.name = name;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
        this.link = link;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
