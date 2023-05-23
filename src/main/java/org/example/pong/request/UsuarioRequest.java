package org.example.pong.request;

public class UsuarioRequest {
    private long id;
    private String nome;

    public UsuarioRequest(String nome) {
        this.nome = nome;
    }

    public UsuarioRequest() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
