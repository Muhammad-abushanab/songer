package com.sing.songer.Controller;

import com.sing.songer.Model.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumController {

    @GetMapping("/albums")
    public String albums(Model albmusModel){
        Album album1 = new Album("Born to die","Lana del rey",9,180,"https://i.pinimg.com/564x/34/32/93/3432934519d074a56031263185e405a9.jpg");
        Album album2 = new Album("The Eminem Show" , "Eminem",19 ,4260,"https://i.pinimg.com/564x/07/13/9c/07139c5c7253898b88652e97c3604466.jpg");
        Album album3 = new Album("This Is Acting" , "Sia" , 18,4230,"https://i.pinimg.com/564x/0a/b9/3a/0ab93a940574edcb06814837533905d2.jpg");
        albmusModel.addAttribute("albums",new Album[]{album1,album2,album3});
        return "albums";
    }
}