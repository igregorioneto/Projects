package br.com.backend.vo;

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
@JsonPropertyOrder({ "id", "vaga_id", "candidato_id", "score" })
public class VagaCandidatoVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("id")
    private Long key;
    @JsonProperty("vaga_id")
    private Long vagaId;
    @JsonProperty("candidato_id")
    private Long candidatoId;
    @JsonProperty("score")
    private Integer score = 0;

    public VagaCandidatoVO() {
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public Long getVagaId() {
        return vagaId;
    }

    public void setVagaId(Long vagaId) {
        this.vagaId = vagaId;
    }

    public Long getCandidatoId() {
        return candidatoId;
    }

    public void setCandidatoId(Long candidatoId) {
        this.candidatoId = candidatoId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VagaCandidatoVO that = (VagaCandidatoVO) o;
        return Objects.equals(key, that.key) && Objects.equals(vagaId, that.vagaId) && Objects.equals(candidatoId, that.candidatoId) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, vagaId, candidatoId, score);
    }
}
