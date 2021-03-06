package com.data.app;

import java.util.logging.Logger;

public class Song implements Comparable<Song>{
    private String title;
    private String artist;
    private String rating;
    private String bpm;
    public transient final static Logger LOGGER = Logger.getLogger(Song.class.getName());

    public Song(String title, String artist, String rating, String bpm) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.bpm = bpm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getBpm() {
        return bpm;
    }

    @Override
    public String toString() {
        return title.concat(" - ").concat(artist);
    }

    @Override 
    public int compareTo(Song song) {
        return title.compareTo(song.getTitle());
    }

    @Override
    public boolean equals(Object aSong) {

        Song s = (Song) aSong;
        return getTitle().equals(s.getTitle());
    }

    @Override
    public int hashCode() {
        LOGGER.info(Integer.toString(title.hashCode()));
        return title.hashCode();
        
    }
    
}