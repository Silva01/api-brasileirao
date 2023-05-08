package br.net.silva.daniel.api_brasileirao.domain.shared.repository;

import br.net.silva.daniel.api_brasileirao.domain.shared.interfaces.Aggregate;

public interface DeleteRepository<T> {
    void deleteById(Long id);
}
