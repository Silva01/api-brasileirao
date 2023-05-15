package br.net.silva.daniel.api_brasileirao.infrastructure.service;

import br.net.silva.daniel.api_brasileirao.domain.player.domain.Player;
import br.net.silva.daniel.api_brasileirao.domain.player.exception.PlayerNotExistsException;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.*;
import br.net.silva.daniel.api_brasileirao.domain.team.exception.TeamNotExistsException;
import br.net.silva.daniel.api_brasileirao.infrastructure.model.PlayerModel;
import br.net.silva.daniel.api_brasileirao.infrastructure.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public final class PlayerService implements SaveRepository<Player>, FindAllRepository<Player>, UpdateRespository<Player>, FindByIdRepository<Player>, DeleteRepository<Player> {

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

    @Override
    public Player update(Player aggregate) {
        PlayerModel playerModel = playerRepository.findById(aggregate.getId()).orElseThrow(PlayerNotExistsException::new);
        playerModel.setName(Objects.nonNull(aggregate.getName()) ? aggregate.getName() : playerModel.getName());
        playerModel.setBirthDate(Objects.nonNull(aggregate.getBirthDate()) ? aggregate.getBirthDate() : playerModel.getBirthDate());
        playerModel.setCountry(Objects.nonNull(aggregate.getCountry()) ? aggregate.getCountry() : playerModel.getCountry());
        playerModel.setTeamId(Objects.nonNull(aggregate.getTeamId()) ? aggregate.getTeamId() : playerModel.getTeamId());
        playerRepository.save(playerModel);
        return aggregate;
    }

    @Override
    public Player findById(Long id) throws TeamNotExistsException {
        return playerRepository
                .findById(id)
                .map(playerModel -> new Player(playerModel.getName(), playerModel.getBirthDate(), playerModel.getCountry(), playerModel.getTeamId(), playerModel.getId()))
                .orElseThrow(PlayerNotExistsException::new);
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }
}
