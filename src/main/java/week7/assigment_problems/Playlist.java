package week7.assigment_problems;

import java.util.Arrays;

public class Playlist {
    private String[] songs;
    private int songCount;

    public Playlist(int maxSongs) {
        this.songs = new String[maxSongs];
        this.songCount = 0;
    }

    public void addSong(String songTitle) {
        if (this.songCount < this.songs.length) {
            this.songs[this.songCount] = songTitle;
            this.songCount++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(this.songs, this.songCount);
    }

    public int getSongCount() {
        return this.songCount;
    }
}
