package br.net.silva.daniel.api_brasileirao.domain.shared.repository;

public interface UpdateRespository <T>{
    T update(T aggregate);
}
