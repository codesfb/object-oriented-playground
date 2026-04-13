package main.java.musicPlaylist.src;

import java.time.Duration;
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
    public String getTotalDurationFormatted() {
        int totalSeconds = 0;
        for (int i = 0; i < songCount; i++) {
            totalSeconds += songs[i].getDurationSeconds();
        }

        // Criamos um objeto Duration a partir dos segundos totais
        Duration duration = Duration.ofSeconds(totalSeconds);

        long minutes = duration.toMinutes();
        int seconds = duration.toSecondsPart(); // Pega apenas o que restou (0-59)

        return String.format("%d:%02d", minutes, seconds);
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
