package br.net.silva.daniel.api_brasileirao.usecase.team.domain;

import br.net.silva.daniel.api_brasileirao.domain.shared.repository.DeleteRepository;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.usecase.shared.interfaces.UseCase;

public class DeleteTeamUseCase implements UseCase<Void> {

    private final Long id;
    private final DeleteRepository<Team> deleteRepository;

    public DeleteTeamUseCase(Long id, DeleteRepository<Team> deleteRepository) {
        this.id = id;
        this.deleteRepository = deleteRepository;
    }

    @Override
    public Void execute() {
        deleteRepository.deleteById(id);
        return null;
    }
}
