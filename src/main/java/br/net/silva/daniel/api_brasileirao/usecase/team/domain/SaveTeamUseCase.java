package br.net.silva.daniel.api_brasileirao.usecase.team.domain;

import br.net.silva.daniel.api_brasileirao.domain.shared.interfaces.Aggregate;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.SaveRepository;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.usecase.team.interfaces.UseCase;

public class SaveTeamUseCase implements UseCase<Team> {

    private final SaveRepository<Team> repository;
    private final Aggregate<Team> team;

    public SaveTeamUseCase(SaveRepository<Team> repository, Aggregate<Team> team) {
        this.repository = repository;
        this.team = team;
    }


    @Override
    public Team execute() {
        return repository.save(team.getAggregate());
    }
}
