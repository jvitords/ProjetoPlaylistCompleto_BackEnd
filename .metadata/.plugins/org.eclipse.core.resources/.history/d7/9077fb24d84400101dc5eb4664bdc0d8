package com.playlist.entities.dto.playlistDTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.playlist.entities.Musica;
import com.playlist.entities.Playlist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaylistGetDTO implements Serializable { // class responsável por retornar os dados do GET

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String descricao;
	
	private Set<Musica> musicas = new HashSet();

	public PlaylistGetDTO() {
	}

	public PlaylistGetDTO(Playlist playlist) {
		this.nome = playlist.getNome();
		this.descricao = playlist.getDescricao();
		this.musicas = playlist.getListMusicas();
	}

}