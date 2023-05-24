package org.example.pong.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "usuarios_id_seq"
    )
    @SequenceGenerator(
            name = "usuarios_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column
    private String nome;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
