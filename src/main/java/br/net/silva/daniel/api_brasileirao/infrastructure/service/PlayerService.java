package br.net.silva.daniel.api_brasileirao.infrastructure.service;

import br.net.silva.daniel.api_brasileirao.domain.player.domain.Player;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.FindAllRepository;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.SaveRepository;
import br.net.silva.daniel.api_brasileirao.infrastructure.model.PlayerModel;
import br.net.silva.daniel.api_brasileirao.infrastructure.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class PlayerService implements SaveRepository<Player>, FindAllRepository<Player> {

    private final PlayerRepository playerRepository;
    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player save(Player aggregate) {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setName(aggregate.getName());
        playerModel.setBirthDate(aggregate.getBirthDate());
        playerModel.setCountry(aggregate.getCountry());
        playerModel.setTeamId(aggregate.getTeamId());
        playerRepository.save(playerModel);
        return aggregate;
    }

    @Override
    public List<Player> findAll() {
        return playerRepository
                .findAll()
                .stream()
                .map(playerModel -> new Player(playerModel.getName(), playerModel.getBirthDate(), playerModel.getCountry(), playerModel.getTeamId(), playerModel.getId()))
                .toList();
    }
}
