package br.com.backend.models;

import jakarta.persistence.*;

import java.util.Objects;

/*
 * VagaCandidato
 * @author Greg
 * @verion 1.0
 * @since 2023-12-12
 * */
@Entity
@Table(name = "vaga_candidato")
public class VagaCandidato extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;

    @ManyToOne
    @JoinColumn(name = "candidato_id")
    private Candidato candidato;

    @Column(name = "score")
    private Integer score = 0;

    public VagaCandidato() {
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
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
        VagaCandidato that = (VagaCandidato) o;
        return Objects.equals(vaga, that.vaga) && Objects.equals(candidato, that.candidato) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vaga, candidato, score);
    }
}
