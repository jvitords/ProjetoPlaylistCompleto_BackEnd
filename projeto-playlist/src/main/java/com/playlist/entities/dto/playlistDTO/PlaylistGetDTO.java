package com.playlist.entities.dto.playlistDTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.playlist.entities.Musica;
import com.playlist.entities.Playlist;
import com.playlist.entities.dto.musicaDTO.MusicaGetDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaylistGetDTO implements Serializable { // class responsável por retornar os dados do GET

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String descricao;
	
	private Set<MusicaGetDTO> musicas = new HashSet();

	public PlaylistGetDTO() {
	}

	public PlaylistGetDTO(Playlist playlist) {
		this.nome = playlist.getNome();
		this.descricao = playlist.getDescricao();
		this.musicas = playlist.getListMusicas().stream()
                .map(MusicaGetDTO::new)
                .collect(Collectors.toSet());;
	}

}