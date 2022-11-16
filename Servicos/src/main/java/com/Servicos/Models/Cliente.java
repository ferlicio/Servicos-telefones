package com.Servicos.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String nm_cliente;

    @Column(nullable = false, length = 200)
    private String nm_email;

    @Column(nullable = false, length = 200)
    private String nr_cep;

    @Column(nullable = false, length = 200)
    private String nm_endereco;

    @Column(nullable = false, length = 200)
    private String nm_bairro;

    @Column(nullable = false, length = 200)
    private String nm_complemento;

    @Column(nullable = false, length = 200)
    private String nm_cidade;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Telefone> telefones = new ArrayList<Telefone>();

    public Integer getIdCliente() {
        return id;
    }

    public void setIdCliente(Integer idCliente) {
        this.id = idCliente;
    }

    public String getNm_cliente() {
        return nm_cliente;
    }

    public void setNm_cliente(String nm_cliente) {
        this.nm_cliente = nm_cliente;
    }

    public String getNm_email() {
        return nm_email;
    }

    public void setNm_email(String nm_email) {
        this.nm_email = nm_email;
    }

    public String getNr_cep() {
        return nr_cep;
    }

    public void setNr_cep(String nr_cep) {
        this.nr_cep = nr_cep;
    }

    public String getNm_endereco() {
        return nm_endereco;
    }

    public void setNm_endereco(String nm_endereco) {
        this.nm_endereco = nm_endereco;
    }

    public String getNm_bairro() {
        return nm_bairro;
    }

    public void setNm_bairro(String nm_bairro) {
        this.nm_bairro = nm_bairro;
    }

    public String getNm_complemento() {
        return nm_complemento;
    }

    public void setNm_complemento(String nm_complemento) {
        this.nm_complemento = nm_complemento;
    }

    public String getNm_cidade() {
        return nm_cidade;
    }

    public void setNm_cidade(String nm_cidade) {
        this.nm_cidade = nm_cidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
