package br.com.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;

/*
 * Candidato
 * @author Greg
 * @verion 1.0
 * @since 2023-12-12
 * */
@Entity
@Table(name = "candidatos")
public class Candidato extends BaseEntity{

    @Column(length = 255, nullable = false)
    private String nome;
    @Column(length = 80, nullable = false)
    private String profissao;

    private Character localizacao;
    @Column(length = 1, nullable = false)
    private Character nivel;

    @OneToMany(mappedBy = "candidato")
    @JsonIgnore
    private List<VagaCandidato> candidaturas;

    public Candidato() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
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
        Candidato candidato = (Candidato) o;
        return Objects.equals(nome, candidato.nome) && Objects.equals(profissao, candidato.profissao) && Objects.equals(localizacao, candidato.localizacao) && Objects.equals(nivel, candidato.nivel) && Objects.equals(candidaturas, candidato.candidaturas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, profissao, localizacao, nivel, candidaturas);
    }
}
