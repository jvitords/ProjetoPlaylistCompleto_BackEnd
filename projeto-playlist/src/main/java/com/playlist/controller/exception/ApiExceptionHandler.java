package com.playlist.controller.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.playlist.service.exception.NotFoundException;
import com.playlist.service.exception.PlaylistExistenteException;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class) 
	public ResponseEntity exceptionNotFound() {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErroValidacao>> exceptionErroValidacao(MethodArgumentNotValidException exception) {
        List<DadosErroValidacao> erros = exception.getFieldErrors().stream().map(DadosErroValidacao::new).toList();
        return ResponseEntity.badRequest().body(erros);
    }
	
	@ExceptionHandler(PlaylistExistenteException.class)
	public ResponseEntity<String> handlePlaylistAlreadyExists(PlaylistExistenteException exception) {
	    return ResponseEntity.badRequest().body(exception.getMessage());
	}


    private record DadosErroValidacao(String campo, String mensagem) {
        public DadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}