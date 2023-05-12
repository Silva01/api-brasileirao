package br.net.silva.daniel.api_brasileirao.usecase.player.domain;

import br.net.silva.daniel.api_brasileirao.domain.player.domain.Player;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.DeleteRepository;
import br.net.silva.daniel.api_brasileirao.usecase.shared.interfaces.UseCase;

public class DeletePlayerUseCase implements UseCase<Void> {

    private final Long id;
    private final DeleteRepository<Player> deleteRepository;

    public DeletePlayerUseCase(Long id, DeleteRepository<Player> deleteRepository) {
        this.id = id;
        this.deleteRepository = deleteRepository;
    }

    @Override
    public Void execute() {
        deleteRepository.deleteById(id);
        return null;
    }
}
