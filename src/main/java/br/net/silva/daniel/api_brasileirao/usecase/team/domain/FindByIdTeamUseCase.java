package br.net.silva.daniel.api_brasileirao.usecase.team.domain;

import br.net.silva.daniel.api_brasileirao.domain.shared.repository.FindByIdRepository;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.domain.team.exception.TeamNotExistsException;
import br.net.silva.daniel.api_brasileirao.usecase.team.interfaces.UseCase;

public class FindByIdTeamUseCase implements UseCase<Team> {

    private final Long id;
    private final FindByIdRepository<Team> repository;

    public FindByIdTeamUseCase(Long id, FindByIdRepository<Team> repository) {
        this.id = id;
        this.repository = repository;
    }

    @Override
    public Team execute() {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new TeamNotExistsException();
        }
    }
}
