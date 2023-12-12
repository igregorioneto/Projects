package br.com.backend.vo;

import br.com.backend.models.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

/*
 * CandidatoVO
 * @author Greg
 * @verion 1.0
 * @since 2023-12-12
 * */
@JsonPropertyOrder({ "id", "nome", "profissao", "localizacao", "nivel" })
public class CandidatoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private Long key;
    private String nome;
    private String profissao;
    private Character localizacao;
    private Character nivel;

    public CandidatoVO() {
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidatoVO that = (CandidatoVO) o;
        return Objects.equals(key, that.key) && Objects.equals(nome, that.nome) && Objects.equals(profissao, that.profissao) && Objects.equals(localizacao, that.localizacao) && Objects.equals(nivel, that.nivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, nome, profissao, localizacao, nivel);
    }
}
