package br.net.silva.daniel.api_brasileirao.infrastructure.service;

import br.net.silva.daniel.api_brasileirao.domain.player.domain.Player;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.SaveRepository;
import br.net.silva.daniel.api_brasileirao.infrastructure.model.PlayerModel;
import br.net.silva.daniel.api_brasileirao.infrastructure.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class PlayerService implements SaveRepository<Player> {

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
        playerModel.setTeam(aggregate.getTeamId());
        playerRepository.save(playerModel);
        return aggregate;
    }
}
