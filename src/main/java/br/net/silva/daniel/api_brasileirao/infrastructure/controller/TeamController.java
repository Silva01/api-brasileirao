package br.net.silva.daniel.api_brasileirao.infrastructure.controller;

import br.net.silva.daniel.api_brasileirao.domain.shared.repository.*;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.domain.team.dto.TeamDTO;
import br.net.silva.daniel.api_brasileirao.infrastructure.dto.BodyTeamDTO;
import br.net.silva.daniel.api_brasileirao.usecase.team.domain.*;
import br.net.silva.daniel.api_brasileirao.usecase.team.interfaces.UseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("/team")
public class TeamController {

    private final SaveRepository<Team> saveRepository;
    private final FindAllRepository<Team> findAllRepository;
    private final FindByIdRepository<Team> findByIdRepository;
    private final UpdateRespository<Team> updateRespository;
    private final DeleteRepository<Team> deleteRepository;

    public TeamController(SaveRepository<Team> saveRepository, FindAllRepository<Team> findAllRepository, FindByIdRepository<Team> findByIdRepository, UpdateRespository<Team> updateRespository, DeleteRepository<Team> deleteRepository) {
        this.saveRepository = saveRepository;
        this.findAllRepository = findAllRepository;
        this.findByIdRepository = findByIdRepository;
        this.updateRespository = updateRespository;
        this.deleteRepository = deleteRepository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final BodyTeamDTO teamDTO) {
        UseCase<Team> createUseCase = new SaveTeamUseCase(saveRepository, new Team(teamDTO.getName(), teamDTO.getLocalidade()));
        createUseCase.execute();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Callable<List<TeamDTO>> listAll() {
        UseCase<List<Team>> listAllUseCase = new FindAllTeamsUseCase(findAllRepository);
        return () -> listAllUseCase.execute().stream().map(Team::toDTO).toList();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Callable<TeamDTO> findById(@PathVariable final Long id) {
        UseCase<Team> findByIdTeamUseCase = new FindByIdTeamUseCase(id, findByIdRepository);
        return () -> findByIdTeamUseCase.execute().toDTO();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody BodyTeamDTO body, @PathVariable final Long id) {
        UseCase<Team> updateTeamUseCase = new UpdateTeamUseCase(updateRespository, new Team(body.getName(), body.getLocalidade(), id));
        updateTeamUseCase.execute();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        UseCase<Void> deleteTeamUseCase = new DeleteTeamUseCase(id, deleteRepository);
        deleteTeamUseCase.execute();
    }

}
