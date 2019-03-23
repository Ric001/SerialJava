package com.data.app;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Collections;
import java.util.Comparator;

public class JukeBox1 {

    private ArrayList<Song> songList = new ArrayList<Song>();


    class ArtistCompare implements Comparator<Song> {
        @Override 
        public int compare(Song one, Song two) {
            return one.getArtist().compareTo(two.getArtist());
        }
    } 

    public void addSong(String line) {
        String[] tokens = line.split("/");
        songList.add( new Song(tokens[0], tokens[1], tokens[2], tokens[3]) );
    }

    public void getSongs() {
        String path = System.getProperty("user.dir");
        File songsFile = new File(".\\target\\txt\\Songs.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(songsFile));
            String line; 
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
        
    }
    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);


        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(songList, artistCompare);

        System.out.println(songList);
    }
}