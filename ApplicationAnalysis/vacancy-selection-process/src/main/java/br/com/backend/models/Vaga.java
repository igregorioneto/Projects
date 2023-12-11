package br.com.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaga vaga = (Vaga) o;
        return Objects.equals(empresa, vaga.empresa) && Objects.equals(titulo, vaga.titulo) && Objects.equals(descricao, vaga.descricao) && Objects.equals(localizacao, vaga.localizacao) && Objects.equals(nivel, vaga.nivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empresa, titulo, descricao, localizacao, nivel);
    }
}
