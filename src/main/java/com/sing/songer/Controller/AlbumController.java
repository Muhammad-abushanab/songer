package com.sing.songer.Controller;

import com.sing.songer.Model.Album;
import com.sing.songer.repositories.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepo albumRepo;

    @GetMapping("/albums")
    public String getAlbums(Model albmusModel) {
//        Album album1 = new Album("Born to die", "Lana del rey", 9, 180, "https://i.pinimg.com/564x/34/32/93/3432934519d074a56031263185e405a9.jpg");
//        Album album2 = new Album("The Eminem Show", "Eminem", 19, 4260, "https://i.pinimg.com/564x/07/13/9c/07139c5c7253898b88652e97c3604466.jpg");
//        Album album3 = new Album("This Is Acting", "Sia", 18, 4230, "https://i.pinimg.com/564x/0a/b9/3a/0ab93a940574edcb06814837533905d2.jpg");
        List<Album> albums = albumRepo.findAll();
        System.out.println(albums.toString());
        albmusModel.addAttribute("albums",albums);
        return "albums";
    }

    @PostMapping("/albums/create")
    public RedirectView createAlbum(String title, String artist, String imageUrl, int songCount, int length) {
        if (songCount <= 0 || length <= 0) {
            // Handle invalid data here (e.g., show an error message to the user)
            return new RedirectView("/error");
        }
        System.out.println(imageUrl);
        Album album = new Album(title, artist, songCount, length, imageUrl);
        albumRepo.save(album);
        return new RedirectView("/albums");
    }
}
