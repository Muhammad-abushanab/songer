package com.sing.songer.repositories;

import com.sing.songer.Model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepo extends JpaRepository<Album,Long> {
}
