package main.java.musicPlaylist.src;

public class Song {

    private String title;
    private String artist;
    private int durationSeconds;
    private Genre genre;

    /* what can be static of
    static of(title: String, artist: String, durationSeconds: int, genre: Genre) : Song ??
        * */

    private Song(String title, String artist, int durationSeconds, Genre genre) {
        this.title = title;
        this.artist = artist;
        this.durationSeconds = durationSeconds;
        this.genre = genre;
    }

    public static Song of(String title, String artist, int durationSeconds, Genre genre){
        return (durationSeconds <= 0)?null:new Song(title, artist, durationSeconds,genre);
    }

    @Override
    public String toString() {
        // Formato que será usado dentro do loop da Playlist
        return String.format("%s - %s (%ds)", this.title, this.artist, this.durationSeconds);
    }


    public String formatSongInfo() {
        return String.format("Title:%s \nArtist:%s \nGenre:%s \nDuration:%d \n",
                title, artist, genre, durationSeconds );
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }




    public Genre getGenre() {
        return genre;
    }
}
