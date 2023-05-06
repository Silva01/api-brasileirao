package br.net.silva.daniel.api_brasileirao.usecase.team.domain;

import br.net.silva.daniel.api_brasileirao.domain.shared.repository.FindAllRepository;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.usecase.team.interfaces.UseCase;

import java.util.List;

public class FindAllTeamsUseCase implements UseCase<List<Team>> {

    private final FindAllRepository<Team> repository;

    public FindAllTeamsUseCase(FindAllRepository<Team> repository) {
        this.repository = repository;
    }

    @Override
    public List<Team> execute() {
        return repository.findAll();
    }
}
