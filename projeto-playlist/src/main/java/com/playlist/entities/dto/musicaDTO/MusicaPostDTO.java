package com.playlist.entities.dto.musicaDTO;

import java.io.Serializable;

import com.playlist.entities.Musica;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicaPostDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "O nome da música não pode estar em branco")
	private String titulo;

	@NotBlank(message = "O artista não pode estar em branco")
	private String artista;
	
	@NotBlank(message = "O albúm não pode estar em branco")
	private String album;
	
	@NotNull(message = "O ano não pode estar em branco")
	private Integer ano;
	
	@NotBlank(message = "O genêro não pode estar em branco")
	private String genero;

	public MusicaPostDTO() {}

	public MusicaPostDTO(Musica musicDTO) {
		this.titulo = musicDTO.getTitulo();
		this.artista = musicDTO.getArtista();
		this.album = musicDTO.getAlbum();
		this.ano = musicDTO.getAno();
		this.genero = musicDTO.getGenero();
	}
}
