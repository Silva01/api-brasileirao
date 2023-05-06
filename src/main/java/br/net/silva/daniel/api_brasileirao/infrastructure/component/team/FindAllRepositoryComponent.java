package br.net.silva.daniel.api_brasileirao.infrastructure.component.team;

import br.net.silva.daniel.api_brasileirao.domain.shared.repository.FindAllRepository;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.infrastructure.service.TeamService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllRepositoryComponent {

    public FindAllRepository<Team> createFindAllRepository(TeamService service) {
        return service;
    }
}
