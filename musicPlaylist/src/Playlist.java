import java.time.LocalDate;

public class Playlist {
    private String name;
    private LocalDate creationDate;
    private User owner;
    private Song[] songs;
    private int songCount;

    public Playlist(String name, User owner) {
        this.name = name;
        this.creationDate = LocalDate.now();
        this.owner = owner;
        this.songs = new Song[30];

    }

    //how to properly use unumeration ?
    public void addSong(Song song){
        if(songCount > 30) return;
        songs[songCount++]=song;
    };
    public void addSong(String title,String artist, int durationSeconds, Genre genre){
        if(songCount > 30) return;
        songs[songCount++]= Song.of(title, artist, durationSeconds,genre);

    };
    public void removeSong(int index){
        if(index < 0 || index >= 30) return;
        songs[index] = null;
        songs[index]= songs[songCount];
        songs[--songCount]=null;

    };
    public int getTotalDurationMinutes(){
        int acc=0;
        for (int i = 0; i < songCount; i++) {
            acc+=songs[i].getDurationSeconds();
        }
        return acc / 60;
    }


    public String getPlaylistAsString(){
        StringBuilder sb = new StringBuilder();
        sb.append("PLAYLIST:").append("\n");
        for (int i = 0; i < songCount; i++) {
            sb.append(songs[i].toString()).append("\n");
        }
        return sb.toString();
    }



    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getOwner () {
        return String.format("Owner: %s", this.owner );
    }

    public Song[] getSongs() {
        return songs;
    }

    public int getSongCount() {
        return songCount;
    }
}
