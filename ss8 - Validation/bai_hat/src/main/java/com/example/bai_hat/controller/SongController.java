package com.example.bai_hat.controller;

import com.example.bai_hat.dto.SongDTO;
import com.example.bai_hat.model.Song;
import com.example.bai_hat.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String displaySong(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String showCreateSong(Model model) {
        model.addAttribute("songDTO", new Song());
        return "create";
    }

    @PostMapping("/index")
    public String createSong(@Validated @ModelAttribute("songDTO") SongDTO songDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        new SongDTO().validate(songDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/song";
    }

    @GetMapping("/update")
    public String showUpdateSong(@RequestParam("id") Long id, Model model) {
        System.out.println("hello");
        Song song = songService.findById(id);

        model.addAttribute("songDTO", song);

        return "update";
    }

    @PostMapping("/update")
    public String updateSong(
            @Validated @ModelAttribute("songDTO") SongDTO songDTO,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        new SongDTO().validate(songDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "update";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);

        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "Bài hát đã được cập nhật thành công");
        return "redirect:/song";
    }
}
