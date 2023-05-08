package br.net.silva.daniel.api_brasileirao.usecase.team.domain;

import br.net.silva.daniel.api_brasileirao.domain.shared.repository.UpdateRespository;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.usecase.team.interfaces.UseCase;

public class UpdateTeamUseCase implements UseCase<Team> {

    private final UpdateRespository<Team> repository;
    private final Team team;

    public UpdateTeamUseCase(UpdateRespository<Team> repository, Team team) {
        this.repository = repository;
        this.team = team;
    }

    @Override
    public Team execute() {
        return repository.update(team);
    }
}
