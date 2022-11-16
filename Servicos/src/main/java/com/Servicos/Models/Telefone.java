package com.Servicos.Models;

import javax.persistence.*;

@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Cliente cliente;

    @Column(nullable = false, length = 45)
    private String nrTelefone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer idTelefone) {
        this.id = idTelefone;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }
}
