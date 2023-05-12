package br.net.silva.daniel.api_brasileirao.infrastructure.exception;

import br.net.silva.daniel.api_brasileirao.domain.player.exception.PlayerNotExistsException;
import br.net.silva.daniel.api_brasileirao.infrastructure.dto.BodyErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(value = PlayerNotExistsException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public BodyErrorDTO playerNotExistsException() {
        return new BodyErrorDTO(HttpStatus.NOT_FOUND.value(), "Player not found");
    }
}
