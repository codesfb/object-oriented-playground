void main() {
    //I can't  do this because Song is private

//    Song s2 = new Song(
//            "dont wake me up","AVICCI", 150,Genre.ELECTRONIC);


    User user1 = new User("Fabio",false);

    User user2 = new User("Clara",false);
    Playlist playlist = new Playlist("MySongs", user1);
    user2.follow(playlist);
    playlist.addSong("dont wake me up","AVICCI", 150,Genre.ELECTRONIC);
    playlist.addSong("They dont really care","Michael Jackson", 200,Genre.POP);


    IO.println(playlist.getPlaylistAsString());
    IO.println("Duração total da playlist " + playlist.getTotalDurationMinutes());
    IO.println(playlist.getOwner());// como faz pra n mostrar User@38af3868







}
