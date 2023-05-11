package br.net.silva.daniel.api_brasileirao.infrastructure.controller;

import br.net.silva.daniel.api_brasileirao.domain.player.domain.Player;
import br.net.silva.daniel.api_brasileirao.domain.player.dto.PlayerDTO;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.FindAllRepository;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.SaveRepository;
import br.net.silva.daniel.api_brasileirao.infrastructure.dto.BodyPlayerDTO;
import br.net.silva.daniel.api_brasileirao.usecase.player.domain.FindAllPlayerUseCase;
import br.net.silva.daniel.api_brasileirao.usecase.player.domain.SavePlayerUseCase;
import br.net.silva.daniel.api_brasileirao.usecase.shared.interfaces.UseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("/player")
public final class PlayerController {

    private final SaveRepository<Player> saveRepository;
    private final FindAllRepository<Player> findAllRepository;

    @Autowired
    public PlayerController(SaveRepository<Player> saveRepository, FindAllRepository<Player> findAllRepository) {
        this.saveRepository = saveRepository;
        this.findAllRepository = findAllRepository;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody BodyPlayerDTO body) {
        UseCase<Player> createANewPlayerUseCase = new SavePlayerUseCase(saveRepository, new Player(body.getName(), body.getBirthDate(), body.getCountry(), body.getTeamId(), null));
        createANewPlayerUseCase.execute();
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id, @RequestBody BodyPlayerDTO body) {


    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Callable<PlayerDTO> findById(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Callable<List<PlayerDTO>> findAll() {
        UseCase<List<Player>> findAllPlayersUseCase = new FindAllPlayerUseCase(findAllRepository);
        return () -> findAllPlayersUseCase.execute()
                .stream()
                .map(player -> new PlayerDTO(player.getName(), player.getBirthDate(), player.getCountry(), player.getTeamId(), player.getTeamId()))
                .toList();
    }
}
