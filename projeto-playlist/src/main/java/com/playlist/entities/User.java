package com.playlist.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable = false)
    private String username;
	@Column(nullable = false)
    private String password;
    
    @ElementCollection(fetch = FetchType.EAGER) // cria uma nova tabela com os roles e eles serão carregados junto com username e password pelo spring
    @Column(nullable = false)
    private Set<Roles> roles = new HashSet<>();
    
    @OneToMany(mappedBy = "user")
    private Set<Playlist> playlists = new HashSet<>();

	public User(Long id, String username, String password, Set<Roles> roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
    
    
}
