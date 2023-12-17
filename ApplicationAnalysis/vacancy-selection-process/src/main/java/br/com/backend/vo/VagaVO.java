package br.com.backend.vo;

import br.com.backend.enums.Localidade;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Objects;

/*
 * Classe VO que representa a classe Vaga para o padrão VO no projeto
 * @author Greg
 * @verion 1.0
 * @since 2023-12-11
 * */
@JsonPropertyOrder({ "id", "empresa", "titulo", "descricao", "localizacao", "nivel" })
public class VagaVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private Long key;
    private String empresa;
    private String titulo;
    private String descricao;
    private Localidade localizacao;
    private Character nivel;

    public VagaVO() {
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
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

    public Localidade getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localidade localizacao) {
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
        VagaVO vagaVO = (VagaVO) o;
        return Objects.equals(key, vagaVO.key) && Objects.equals(empresa, vagaVO.empresa) && Objects.equals(titulo, vagaVO.titulo) && Objects.equals(descricao, vagaVO.descricao) && localizacao == vagaVO.localizacao && Objects.equals(nivel, vagaVO.nivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, empresa, titulo, descricao, localizacao, nivel);
    }
}
