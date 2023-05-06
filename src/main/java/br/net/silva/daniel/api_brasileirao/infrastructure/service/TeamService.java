package br.net.silva.daniel.api_brasileirao.infrastructure.service;

import br.net.silva.daniel.api_brasileirao.domain.shared.repository.FindAllRepository;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.SaveRepository;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.infrastructure.model.TeamModel;
import br.net.silva.daniel.api_brasileirao.infrastructure.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService implements SaveRepository<Team>, FindAllRepository<Team> {

    private TeamRepository repository;

    @Autowired
    public TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public Team save(Team aggregate) {
        TeamModel model = new TeamModel();
        model.setName(aggregate.getName());
        model.setLocalidade(aggregate.getLocalidade());
        repository.save(model);
        return aggregate;
    }

    @Override
    public List<Team> findAll() {
        return repository.findAll().stream().map(teamModel -> new Team(teamModel.getName(), teamModel.getLocalidade())).toList();
    }
}
