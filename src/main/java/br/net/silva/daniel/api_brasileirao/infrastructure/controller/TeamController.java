package br.net.silva.daniel.api_brasileirao.infrastructure.controller;

import br.net.silva.daniel.api_brasileirao.domain.shared.repository.SaveRepository;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.domain.team.dto.TeamDTO;
import br.net.silva.daniel.api_brasileirao.usecase.team.domain.SaveTeamUseCase;
import br.net.silva.daniel.api_brasileirao.usecase.team.interfaces.UseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("/team")
public class TeamController {

    private final SaveRepository<Team> saveRepository;

    public TeamController(SaveRepository<Team> saveRepository) {
        this.saveRepository = saveRepository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final TeamDTO teamDTO) {
        UseCase<Team> createUseCase = new SaveTeamUseCase(saveRepository, new Team(teamDTO.getName(), teamDTO.getLocalidade()));
        createUseCase.execute();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Callable<List<TeamDTO>> listAll() {
        return () -> new ArrayList<>();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Callable<TeamDTO> findById(@PathVariable final Long id) {
        return () -> new TeamDTO();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable final Long id) {

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {

    }

}