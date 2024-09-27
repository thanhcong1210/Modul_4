package com.example.bai_hat.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@NoArgsConstructor
public class SongDTO implements Validator {
    private String title;
    private String artist;
    private String album;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO songDTO = (SongDTO) target;
        // Kiểm tra title
        if ("".equals(songDTO.getTitle())) {
            errors.rejectValue("title", null, "Title is required");
        } else if (!songDTO.getTitle().matches("^[a-zA-Z\\s]+$")) {
            errors.rejectValue("title", null, "Title must contain only letters and spaces");
        }

// Kiểm tra artist
        if ("".equals(songDTO.getArtist())) {
            errors.rejectValue("artist", null, "Artist is required");
        } else if (!songDTO.getArtist().matches("^[a-zA-Z\\s]+$")) {
            errors.rejectValue("artist", null, "Artist name must contain only letters and spaces");
        }

// Kiểm tra album
        if ("".equals(songDTO.getAlbum())) {
            errors.rejectValue("album", null, "Album is required");
        } else if (!songDTO.getAlbum().matches("^[a-zA-Z\\s]+$")) {
            errors.rejectValue("album", null, "Album name must contain only letters and spaces");
        }
    }
}
