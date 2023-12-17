package br.com.backend.util;

import br.com.backend.enums.Localidade;
import org.springframework.cglib.core.Local;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphLocalidade {
    Localidade local;
    Map<GraphLocalidade, Integer> vizinhos;

    static List<Localidade> caminho;

    public GraphLocalidade(Localidade local) {
        this.local = local;
        this.vizinhos = new HashMap<>();
        this.caminho = new ArrayList<>();
    }

    public void addVizinho(GraphLocalidade vizinho, int val) {
        this.vizinhos.put(vizinho, val);
    }

    /*
    * Percorrendo a localidade com base em um GraphLocalidade de inicio e GraphLocalidade destino
    * @param GraphLocalidade
    * @param GraphLocalidade
    * @param List<Localidade>
    * @return
    * */
    public static void percorrerLocais(
            GraphLocalidade inicio,
            GraphLocalidade destino) {

        caminho.add(inicio.local);

        if (inicio == destino) {
            return;
        }

        for (GraphLocalidade vizinho:inicio.vizinhos.keySet()) {
            if (!caminho.contains(vizinho.local)) {
                vizinho.percorrerLocais(vizinho, destino);
                if (caminho.get(caminho.size() - 1) == destino.local) {
                    return;
                }
            }
        }

        caminho.remove(caminho.size() - 1);
    }

}
