package com.data.app;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Collections;
public class JukeBox1 {

    private ArrayList<Song> songList = new ArrayList<Song>();

    public void addSong(String line) {
        String[] tokens = line.split("/");
        songList.add( new Song(tokens[0], tokens[1], tokens[2], tokens[3]) );
        
    }

    public void getSongs() {
        File songsFile = new File("C:\\Users\\jose osorio soto\\myapp\\DataStructures\\DataI\\JukeBox\\target\\txt\\Songs.txt");
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
        System.out.println(songList);
    }
}