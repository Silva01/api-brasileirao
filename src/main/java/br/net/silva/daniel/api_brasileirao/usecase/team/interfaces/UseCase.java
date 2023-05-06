package br.net.silva.daniel.api_brasileirao.usecase.team.interfaces;

import br.net.silva.daniel.api_brasileirao.domain.shared.interfaces.Aggregate;

public interface UseCase <T> {
    T execute();
}
