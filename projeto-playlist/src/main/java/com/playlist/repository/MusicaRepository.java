package com.playlist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.playlist.entities.Musica;

@Repository
public interface MusicaRepository  extends JpaRepository<Musica, Long>{
	Optional<Musica> findByTitulo(String name);
	boolean existsByTituloIgnoreCase(String name);
	List<Musica> findByTituloContainingIgnoreCase(String name);
}
