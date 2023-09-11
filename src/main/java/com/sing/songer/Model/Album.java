package com.sing.songer.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "artist", nullable = false)
    private String artist;
    @Column(name = "songCount", nullable = false)
    private int songCount;
    @Column(name = "length", nullable = false)
    private int length;
    @Column(name = "imageUrl", nullable = true)
    private String imageUrl;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Song> songs;


    public Album(String title, String artist, int songCount, int length, String imageUrl) {
        this.artist = artist;
        this.imageUrl = imageUrl;
        this.title = title;
        this.songCount = songCount;
        this.length = length;
    }

    public Album() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Song> getSongs() {
        return songs;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;

    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
