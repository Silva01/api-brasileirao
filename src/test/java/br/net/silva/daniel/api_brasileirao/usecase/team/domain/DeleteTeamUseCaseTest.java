package br.net.silva.daniel.api_brasileirao.usecase.team.domain;

import br.net.silva.daniel.api_brasileirao.domain.shared.repository.DeleteRepository;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.FindByIdRepository;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.SaveRepository;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.domain.team.exception.TeamNotExistsException;
import br.net.silva.daniel.api_brasileirao.infrastructure.ApiBrasileiraoApplication;
import br.net.silva.daniel.api_brasileirao.usecase.team.interfaces.UseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ApiBrasileiraoApplication.class)
class DeleteTeamUseCaseTest {

    private final SaveRepository<Team> saveRepository;
    private final FindByIdRepository<Team> findByIdRepository;
    private final DeleteRepository<Team> deleteRepository;

    @Autowired
    DeleteTeamUseCaseTest(SaveRepository<Team> saveRepository, FindByIdRepository<Team> findByIdRepository, DeleteRepository<Team> deleteRepository) {
        this.saveRepository = saveRepository;
        this.findByIdRepository = findByIdRepository;
        this.deleteRepository = deleteRepository;
    }

    @Test
    void deve_deletar_um_time() {
        UseCase<Team> createUseCase = new SaveTeamUseCase(saveRepository, new Team("São Paulo", "São Paulo"));
        Team teamCreated = createUseCase.execute();

        UseCase<Void> deleteUseCase = new DeleteTeamUseCase(teamCreated.getId(), deleteRepository);
        deleteUseCase.execute();

        UseCase<Team> findByIdTeamUseCase = new FindByIdTeamUseCase(teamCreated.getId(), findByIdRepository);

        Assertions.assertThrows(TeamNotExistsException.class, findByIdTeamUseCase::execute);
    }

}