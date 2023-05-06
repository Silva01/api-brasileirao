package br.net.silva.daniel.api_brasileirao.infrastructure.repository;

import br.net.silva.daniel.api_brasileirao.infrastructure.model.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamModel, Long> {
}
