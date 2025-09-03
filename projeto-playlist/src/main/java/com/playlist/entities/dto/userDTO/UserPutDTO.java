package com.playlist.entities.dto.userDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.playlist.entities.User;

@JsonIgnoreProperties(ignoreUnknown = false) // não aceita campos desconhecidos
public record UserPutDTO(String password) {
	
	public String getPassword() {
		return password;
	}
}
