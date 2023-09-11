package com.sing.songer.Controller;

import com.sing.songer.Exceptions.AlbumNotFoundException;
import com.sing.songer.Model.Album;
import com.sing.songer.Model.Song;
import com.sing.songer.repositories.AlbumRepo;
import com.sing.songer.repositories.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {
    @Autowired
    AlbumRepo albumRepo;
    @Autowired
    SongRepo songRepo;

    @PostMapping("/add-song")
    public RedirectView addSong(String title, int length, int trackNumber, Long albumId) {
        Album album = albumRepo.findById(albumId).orElseThrow(() -> new AlbumNotFoundException("No Album found"));
        Song song = new Song(title, length, trackNumber, album);
        songRepo.save(song);
        return new RedirectView("/albums");
    }
    @DeleteMapping("/delete-song/{songId}")
    public RedirectView deleteSong(@PathVariable long songId){
        songRepo.deleteById(songId);
        return new RedirectView("/albums");
    }
}
