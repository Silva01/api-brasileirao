package br.net.silva.daniel.api_brasileirao.infrastructure.dto;

public class BodyErrorDTO {
    private int cod;
    private String message;

    public BodyErrorDTO(int cod, String message) {
        this.cod = cod;
        this.message = message;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
