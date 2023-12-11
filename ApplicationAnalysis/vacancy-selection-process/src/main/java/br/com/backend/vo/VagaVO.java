package br.com.backend.vo;

import java.util.Objects;

/*
 * Classe VO que representa a classe Vaga para o padrão VO no projeto
 * @author Greg
 * @verion 1.0
 * @since 2023-12-11
 * */
public class VagaVO {
    private String empresa;
    private String titulo;
    private String descricao;
    private Character localizacao;
    private Character nivel;

    public VagaVO() {
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
        VagaVO vagaVO = (VagaVO) o;
        return Objects.equals(empresa, vagaVO.empresa) && Objects.equals(titulo, vagaVO.titulo) && Objects.equals(descricao, vagaVO.descricao) && Objects.equals(localizacao, vagaVO.localizacao) && Objects.equals(nivel, vagaVO.nivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empresa, titulo, descricao, localizacao, nivel);
    }
}
