package br.net.silva.daniel.api_brasileirao.infrastructure.repository;

import br.net.silva.daniel.api_brasileirao.infrastructure.model.PlayerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerModel, Long> {
}
