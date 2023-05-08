package br.net.silva.daniel.api_brasileirao.infrastructure.service;

import br.net.silva.daniel.api_brasileirao.domain.shared.repository.*;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.domain.team.exception.TeamNotExistsException;
import br.net.silva.daniel.api_brasileirao.infrastructure.model.TeamModel;
import br.net.silva.daniel.api_brasileirao.infrastructure.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TeamService implements SaveRepository<Team>, FindAllRepository<Team>, FindByIdRepository<Team>, UpdateRespository<Team>, DeleteRepository<Team> {

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
        TeamModel response = repository.save(model);
        aggregate.addId(response.getId());
        return aggregate;
    }

    @Override
    public List<Team> findAll() {
        return repository.findAll().stream().map(teamModel -> new Team(teamModel.getName(), teamModel.getLocalidade(), teamModel.getId())).toList();
    }

    @Override
    public Team findById(Long id) throws TeamNotExistsException {
        return repository.findById(id).map(teamModel -> new Team(teamModel.getName(), teamModel.getLocalidade(), teamModel.getId())).orElseThrow(TeamNotExistsException::new);
    }

    @Override
    public Team update(Team aggregate) {
        TeamModel model = repository.findById(aggregate.getId()).orElseThrow(TeamNotExistsException::new);
        model.setName(Objects.nonNull(aggregate.getName()) ? aggregate.getName() : model.getName());
        model.setLocalidade(Objects.nonNull(aggregate.getLocalidade()) ? aggregate.getLocalidade() : model.getLocalidade());
        TeamModel response = repository.save(model);
        return aggregate;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
