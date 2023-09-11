package com.sing.songer.repositories;

import com.sing.songer.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<Song,Long> {
}
