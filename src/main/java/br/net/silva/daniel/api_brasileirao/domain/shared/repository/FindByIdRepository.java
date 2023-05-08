package br.net.silva.daniel.api_brasileirao.domain.shared.repository;

import br.net.silva.daniel.api_brasileirao.domain.team.exception.TeamNotExistsException;

public interface FindByIdRepository <T> {
    T findById(Long id) throws Exception;
}
