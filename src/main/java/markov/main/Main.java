package markov.main;

import markov.lyricsGenerator.LyricsFacade;

public class Main {
    public static void main(String[] args) {
        LyricsFacade f = new LyricsFacade();
        f.addSong("C:\\a\\newbible2.txt");
        f.addSong("C:\\a\\thongsong.txt");
        f.addSong("C:\\a\\thunderroad.txt");

        System.out.println(f.generateSong());
    }
}
