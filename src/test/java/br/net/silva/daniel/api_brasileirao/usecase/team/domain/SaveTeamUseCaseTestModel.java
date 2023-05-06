package br.net.silva.daniel.api_brasileirao.usecase.team.domain;

import br.net.silva.daniel.api_brasileirao.domain.shared.repository.SaveRepository;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.usecase.team.interfaces.UseCase;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {SaveTeamUseCase.class, Team.class, SaveRepository.class})
class SaveTeamUseCaseTestModel {
    private final SaveRepository<Team> saveRepository;

    SaveTeamUseCaseTestModel(SaveRepository<Team> saveRepository) {
        this.saveRepository = saveRepository;
    }

    @Test
    void deve_salvar_um_time() {
        UseCase<Team> useCase = new SaveTeamUseCase(saveRepository, new Team("Flamengo", "RJ"));
        Team response = useCase.execute();

        assertEquals(response.getName(), "Flamengo");
        assertEquals(response.getLocalidade(), "RJ");
    }
}