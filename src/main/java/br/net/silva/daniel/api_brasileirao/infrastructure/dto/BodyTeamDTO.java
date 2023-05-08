package br.net.silva.daniel.api_brasileirao.infrastructure.dto;

public class BodyTeamDTO {

    private String name;
    private String localidade;

    public String getName() {
        return name;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
}
