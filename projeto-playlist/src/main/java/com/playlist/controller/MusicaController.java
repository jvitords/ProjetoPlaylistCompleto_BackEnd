package com.playlist.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.playlist.entities.Musica;
import com.playlist.entities.dto.musicaDTO.MusicaGetDTO;
import com.playlist.entities.dto.musicaDTO.MusicaPostDTO;
import com.playlist.service.MusicaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/musica")
public class MusicaController {

    @Autowired
    private MusicaService musicService;

    // url: /musica?name=nomeDesejado, caso não seja passado nada retorna tudo
    @GetMapping
    public ResponseEntity<List<MusicaGetDTO>> findAllOrByName(@RequestParam(required = false) String name) {
        if (name == null || name.isBlank()) {
            List<Musica> list = musicService.findAll();
            List<MusicaGetDTO> dtoList = list.stream().map(MusicaGetDTO::new).collect(Collectors.toList());
            return ResponseEntity.ok().body(dtoList);
        } else {
            List<Musica> list = musicService.findByName(name);
            List<MusicaGetDTO> dtoList = list.stream().map(MusicaGetDTO::new).collect(Collectors.toList());
            return ResponseEntity.ok().body(dtoList);
        }
    }

    @GetMapping("/{titulo}")
    public ResponseEntity<MusicaGetDTO> findById(@PathVariable String titulo) {
        Musica music = musicService.findByTitulo(titulo);
        MusicaGetDTO dto = new MusicaGetDTO(music);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<MusicaGetDTO> saveNewMusic(@RequestBody @Valid MusicaPostDTO musicDto) {
        Musica music = musicService.fromMusica(musicDto);
        musicService.saveNewmusica(music);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{titulo}")
            .buildAndExpand(music.getTitulo())
            .toUri();
        return ResponseEntity.created(uri).body(new MusicaGetDTO(music));
    }

    @PutMapping("/{titulo}")
    public ResponseEntity<MusicaGetDTO> updateMusic(@PathVariable String titulo, @RequestBody MusicaPostDTO musicDto) {
        Musica updatedMusic = musicService.updateMusica(titulo, musicDto);
        //MusicPostDTO responseDTO = new MusicPostDTO(updatedMusic);
        return ResponseEntity.ok().body(new MusicaGetDTO(updatedMusic));
    }

    // delete usando id
    @DeleteMapping("/{titulo}")
    public ResponseEntity<Void> deleteMusic(@PathVariable String titulo) {
        musicService.deleteByTitulo(titulo);
        return ResponseEntity.noContent().build();
    }
}
