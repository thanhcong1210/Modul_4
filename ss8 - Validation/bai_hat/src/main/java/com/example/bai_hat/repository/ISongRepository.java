package com.example.bai_hat.repository;

import com.example.bai_hat.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Long> {
}
