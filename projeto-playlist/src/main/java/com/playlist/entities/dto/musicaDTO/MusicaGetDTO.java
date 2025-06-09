package com.playlist.entities.dto.musicaDTO;

import java.io.Serializable;

import com.playlist.entities.Musica;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicaGetDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;
	private String artista;
	private String album;
	private Integer ano;
	private String genero;

	public MusicaGetDTO() {}

	public MusicaGetDTO(Musica musicDTO) {
		this.id = musicDTO.getId();
		this.titulo = musicDTO.getTitulo();
		this.artista = musicDTO.getArtista();
		this.album = musicDTO.getAlbum();
		this.ano = musicDTO.getAno();
		this.genero = musicDTO.getGenero();
	}
}
