package com.playlist.entities.dto.playlistDTO;

import java.io.Serializable;

import com.playlist.entities.Playlist;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaylistPostDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "O nome da música está inválido")
	private String nome;
	@NotBlank(message = "A descrição da música está inválido")
	private String descricao;

	public PlaylistPostDTO() {
	}

	public PlaylistPostDTO(Playlist playlist) {
		this.nome = playlist.getNome();
		this.descricao = playlist.getDescricao();
	}
}