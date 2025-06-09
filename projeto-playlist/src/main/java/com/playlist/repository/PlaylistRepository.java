package com.playlist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.playlist.entities.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long>{
	List<Playlist> findByNomeContainingIgnoreCase(String palavra); 
	void deleteByNome(String name);
	Optional<Playlist> findByNome(String name);
	Boolean existsByNomeIgnoreCase(String playlist);
}
