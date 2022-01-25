import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    private Song findSong(String title){
        for(Song checkedSong: this.songs){
            if(checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }
    public boolean addSong(String title,double duration){
        if(findSong(title)==null){
            this.songs.add(new Song(title,duration));
            return true;
        }
        return false;
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){
        int ind = trackNumber-1;
        if((ind>=0) && (ind < this.songs.size())){
            playlist.add(this.songs.get(ind));
            return true;
        }
        System.out.println("The album doesn't have a trah : "+trackNumber);
        return false;
    }
    public boolean addToPlaylist(String title, LinkedList<Song> playlist){
        Song checkedSong = findSong(title);
        if(checkedSong!=null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song "+title+" isn't in this album");
        return false;
    }
}
