package com.playlist.entities.dto.userDTO;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.playlist.entities.Roles;
import com.playlist.entities.User;

@JsonIgnoreProperties(ignoreUnknown = false) // não aceita campos desconhecidos
public record UserDTO(String username, Set<Roles> roles) {
	
	public static User toEntity(UserDTO userDTO) {
		return new User(null, userDTO.username, null, userDTO.roles);
	}
}
