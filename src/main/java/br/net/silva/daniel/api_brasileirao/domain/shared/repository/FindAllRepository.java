package br.net.silva.daniel.api_brasileirao.domain.shared.repository;

import java.util.List;

public interface FindAllRepository <T> {
    List<T> findAll();
}
