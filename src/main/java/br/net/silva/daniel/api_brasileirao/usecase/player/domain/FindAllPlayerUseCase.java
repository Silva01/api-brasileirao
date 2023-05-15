package br.net.silva.daniel.api_brasileirao.usecase.player.domain;

import br.net.silva.daniel.api_brasileirao.domain.player.domain.Player;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.FindAllRepository;
import br.net.silva.daniel.api_brasileirao.usecase.shared.interfaces.UseCase;

import java.util.List;

public class FindAllPlayerUseCase implements UseCase<List<Player>> {

    private final FindAllRepository<Player> repository;

    public FindAllPlayerUseCase(FindAllRepository<Player> repository) {
        this.repository = repository;
    }

    @Override
    public List<Player> execute() {
        return repository.findAll();
    }
}
