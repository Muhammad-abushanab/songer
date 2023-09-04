package com.sing.songer.Model;

public class Album {
    private final String title;
    private final String artist;
    private final int songCount;
    private final int length;
    private final String imageUrl;

    public Album(String title,String artist,int songCount,int length,String imageUrl){
        this.artist = artist;
        this.imageUrl = imageUrl;
        this.title = title;
        this.songCount = songCount;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public int getLength() {
        return length;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
