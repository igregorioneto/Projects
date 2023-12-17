package br.com.backend.enums;

public enum Localidade {
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("A");

    String localidade;
    Localidade(String localidade) {
        this.localidade = localidade;
    }

    public String getLocalidade() {
        return localidade;
    }
}
