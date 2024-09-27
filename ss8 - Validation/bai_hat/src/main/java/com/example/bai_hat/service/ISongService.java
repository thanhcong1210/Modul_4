package com.example.bai_hat.service;

import com.example.bai_hat.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Song findById(Long id);
}
