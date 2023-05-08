package br.net.silva.daniel.api_brasileirao.domain.shared.repository;


public interface FindByIdRepository <T> {
    T findById(Long id) throws Exception;
}
