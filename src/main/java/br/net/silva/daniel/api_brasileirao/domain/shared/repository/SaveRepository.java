package br.net.silva.daniel.api_brasileirao.domain.shared.repository;

import br.net.silva.daniel.api_brasileirao.domain.shared.interfaces.Aggregate;

public interface SaveRepository <T extends Aggregate<T>> {
    T save(T aggregate);
}
