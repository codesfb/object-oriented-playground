package main.java.musicPlaylist.src;

public class User {
    private String username;
    private boolean isPremium;
    private Playlist[] followedPlaylists = new Playlist[10];
    private int followedCount;

    public User(String username,boolean isPremium ) {
        this.username = username;
        this.isPremium = false;
    }

    public void follow(Playlist playlist){
        followedPlaylists[followedCount++]= playlist;
    }

    public void unfollow(Playlist playlist){
        for (int i = 0; i < followedCount; i++) {
            if(followedPlaylists[i].equals(playlist)){
                followedPlaylists[i] = null;
                for (int j = i; j < followedCount-1; j++) {
                    followedPlaylists[i]= followedPlaylists[j+1];
                }
                followedPlaylists[--followedCount] = null;
                return;
            }

        }
    }

    @Override
    public String toString() {
        return this.username;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public Playlist[] getFollowedPlaylists() {
        return followedPlaylists;
    }

    public int getFollowedCount() {
        return followedCount;
    }
}
