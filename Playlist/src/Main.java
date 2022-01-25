import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("1989","Taylor Swift");
        album.addSong("Welcome To New York",3.33);
        album.addSong("Blank Space",3.51);
        album.addSong("Style",3.45);
        album.addSong("Out of the Woods",4.10);
        album.addSong("Shake It Off",3.39);
        album.addSong("I Wish You Would",3.27);
        album.addSong("Bad Blood",3.32);

        albums.add(album);

        album = new Album("Bad Blood","Bastille");
        album.addSong("Pompeii",3.34);
        album.addSong("Things We Lost in the Fire",4.02);
        album.addSong("Bad Blood",3.33);
        album.addSong("Overjoyed",3.26);
        album.addSong("These Streets",2.55);
        album.addSong("Oblivion",3.16);

        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlaylist("Style",playlist);
        albums.get(0).addToPlaylist("1989",playlist);//doesn't exist
        albums.get(1).addToPlaylist("Pompeii",playlist);

        int i = albums.get(0).getSongs().size();
        System.out.println(albums.get(0).getSongs().get(i-1).getTitle());
        System.out.println(i);
        albums.get(0).addToPlayList(8,playlist);
        albums.get(0).addToPlayList(i,playlist);
        albums.get(0).addToPlayList(19,playlist);//doesn't exist
        albums.get(1).addToPlayList(3,playlist);
        albums.get(0).addToPlayList(5,playlist);

       play(playlist);
    }
    private static void play(LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size()==0){
            System.out.println("The playlist is empty.");
            return;
        }else{
            System.out.println("Now playing "+listIterator.next().toString());
            printMenu();
        }
        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist finished.");
                    quit =true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    } else {
                        System.out.println("You have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }else {
                        System.out.println("You are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying "+listIterator.previous().toString());
                            forward = false;
                        }else{
                            System.out.println("You are at the start of the list.");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying "+listIterator.next().toString());
                            forward = true;
                        }else{
                            System.out.println("You have reached the end of the playlist");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playling "+listIterator.next());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("Now playling "+listIterator.previous());
                        }
                    }
                    break;

            }
        }
    }
    private static void printMenu(){
        System.out.println("Available actions: ");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");
    }

    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("----------------------------");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("----------------------------");
    }
}
