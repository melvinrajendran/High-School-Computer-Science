package com.example.orientationlistviewproject;

import java.io.Serializable;

public class MusicArtist implements Serializable {
    private String stageName, name, genre, followers, rank, bio, musicVideoURL, instagramURL;
    private int portraitLocation, albumLocation, instagramLocation;

    public MusicArtist(String stageName, String name, String genre, String followers, String rank, String bio, String musicVideoURL, String instagramURL, int portraitLocation, int albumLocation, int instagramLocation) {
        this.stageName = stageName;
        this.name = name;
        this.genre = genre;
        this.followers = followers;
        this.rank = rank;
        this.bio = bio;
        this.musicVideoURL = musicVideoURL;
        this.instagramURL = instagramURL;
        this.portraitLocation = portraitLocation;
        this.albumLocation = albumLocation;
        this.instagramLocation = instagramLocation;
    }

    public String getStageName() {
        return stageName;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getFollowers() {
        return followers;
    }

    public String getRank() {
        return rank;
    }

    public String getBio() {
        return bio;
    }

    public String getMusicVideoURL() {
        return musicVideoURL;
    }

    public String getInstagramURL() {
        return instagramURL;
    }

    public int getPortraitLocation() {
        return portraitLocation;
    }

    public int getAlbumLocation() {
        return albumLocation;
    }

    public int getInstagramLocation() {
        return instagramLocation;
    }
}