package br.com.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * Vaga
 * @author Greg
 * @verion 1.0
 * @since 2023-12-11
 * */
@Entity
@Table(name = "vagas")
public class Vaga extends BaseEntity{

    @Column(length = 80, nullable = false)
    private String empresa;
    @Column(length = 80, nullable = false)
    private String titulo;
    @Column(length = 100, nullable = false)
    private String descricao;
    @Column(length = 1, nullable = false)
    private Character localizacao;
    @Column(length = 1, nullable = false)
    private Character nivel;

    @OneToMany(mappedBy = "vaga")
    @JsonIgnore
    private List<VagaCandidato> candidaturas;

    public Vaga() {
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Character getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Character localizacao) {
        this.localizacao = localizacao;
    }

    public Character getNivel() {
        return nivel;
    }

    public void setNivel(Character nivel) {
        this.nivel = nivel;
    }

    public List<VagaCandidato> getCandidaturas() {
        return candidaturas;
    }

    public void setCandidaturas(List<VagaCandidato> candidaturas) {
        this.candidaturas = candidaturas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaga vaga = (Vaga) o;
        return Objects.equals(empresa, vaga.empresa) && Objects.equals(titulo, vaga.titulo) && Objects.equals(descricao, vaga.descricao) && Objects.equals(localizacao, vaga.localizacao) && Objects.equals(nivel, vaga.nivel) && Objects.equals(candidaturas, vaga.candidaturas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empresa, titulo, descricao, localizacao, nivel, candidaturas);
    }
}
