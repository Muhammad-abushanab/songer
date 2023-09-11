package com.sing.songer;

import com.sing.songer.Model.Album;
import com.sing.songer.repositories.SongRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class SongerApplicationTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetTitle() {
        Album album = new Album("Album Title", "Artist", 10, 60, "image.jpg");
        assertEquals("Album Title", album.getTitle());
    }

    @Test
    public void testGetArtist() {
        Album album = new Album("Album Title", "Artist", 10, 60, "image.jpg");
        assertEquals("Artist", album.getArtist());
    }

    @Test
    public void testGetSongCount() {
        Album album = new Album("Album Title", "Artist", 10, 60, "image.jpg");
        assertEquals(10, album.getSongCount());
    }

    @Test
    public void testGetLength() {
        Album album = new Album("Album Title", "Artist", 10, 60, "image.jpg");
        assertEquals(60, album.getLength());
    }

    @Test
    public void testGetImageUrl() {
        Album album = new Album("Album Title", "Artist", 10, 60, "image.jpg");
        assertEquals("image.jpg", album.getImageUrl());
    }

    @Test
    public void givenPostRequest_toCreateAn_Album_ShouldCreateARecordInDB() throws Exception {
        mockMvc.perform(
                post("/albums/create")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("title", "The Show")
                        .param("artist", "Shanab")
                        .param("length", String.valueOf(45))
                        .param("songCount", String.valueOf(4))
                        .param("imageUrl", "image.jpg")
        ).andExpect(redirectedUrl("/albums")).andExpect(status().isFound());
    }

    @Test
    public void givenPostRequest_toCreateA_SongToAnAlbum_ShouldCreateARecordInDB() throws Exception {
        mockMvc.perform(
                post("/add-song")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("title", "Slim")
                        .param("length", String.valueOf(45))
                        .param("trackNumber", String.valueOf(2))
                        .param("albumId", String.valueOf(16))
        ).andExpect(redirectedUrl("/albums")).andExpect(status().isFound());
    }

    @Test
    public void givenDeleteRequest_toDeleteASongFromAnAlbum_ShouldBeDeleted() throws Exception {
        mockMvc.perform(
                delete("/delete-song/13")
        ).andExpect(redirectedUrl("/albums")).andExpect(status().isFound());
    }

    @Test
    public void homePageRender() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("<h3>Provided endPoints</h3>")));
    }

    @Test
    public void helloPageRender_AndHelloPageWithParameterRequest() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/hello")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("<h1 >Hello, Guest from Songer App</h1>")));
     mockMvc.perform(
                        MockMvcRequestBuilders.get("/hello?name=mohammad")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("<h1 >Hello, mohammad from Songer App</h1>")));
    }
    @Test public void capitalizePageRender_With_PathVariable() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/capitalize/World"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("<h1>WORLD</h1>")));
    }
}
