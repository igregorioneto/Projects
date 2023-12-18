package br.com.backend.util;

import br.com.backend.enums.Localidade;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
* Criando classe para executar o Grafo em relação a localidade
* para realizar o cálculo do score
*
* @author Greg
* @version 1.0
* @since 2023-12-17
* */
@Component
public class GenerateGraphLocalidade {
    private List<GraphLocalidade> nodes = new ArrayList<>();
    @PostConstruct
    public void init() {
        System.out.println("A classe GenerateGraphLocalidade foi inicializada ao iniciar o Spring Boot.");

        GraphLocalidade nodeA = criarNode(Localidade.A);
        GraphLocalidade nodeB = criarNode(Localidade.B);
        GraphLocalidade nodeC = criarNode(Localidade.C);
        GraphLocalidade nodeD = criarNode(Localidade.D);
        GraphLocalidade nodeE = criarNode(Localidade.E);
        GraphLocalidade nodeF = criarNode(Localidade.F);

        adicionarVizinhos(nodeA, nodeB, 5);
        adicionarVizinhos(nodeB, nodeC, 7);
        adicionarVizinhos(nodeB, nodeD, 3);
        adicionarVizinhos(nodeC, nodeB, 7);
        adicionarVizinhos(nodeC, nodeE, 4);
        adicionarVizinhos(nodeD, nodeB, 3);
        adicionarVizinhos(nodeD, nodeF, 8);
        adicionarVizinhos(nodeE, nodeC, 4);
        adicionarVizinhos(nodeE, nodeD, 10);
        adicionarVizinhos(nodeF, nodeD, 8);

        System.out.println("Vizinhos de B");
        for (Map.Entry<GraphLocalidade, Integer> vizinho:nodeB.vizinhos.entrySet()) {
            System.out.print(vizinho.getValue() + " ");
        }

        System.out.println("Local B ao E");
        GraphLocalidade.percorrerLocais(nodeB, nodeE);
        for (Localidade e:GraphLocalidade.caminho) {
            System.out.print(e.getLocalidade() + " ");
        }
        System.out.println();
    }

    private GraphLocalidade criarNode(Localidade local) {
        GraphLocalidade node = new GraphLocalidade(local);
        nodes.add(node);
        return node;
    }

    private void adicionarVizinhos(GraphLocalidade origem, GraphLocalidade destino, int val) {
        origem.addVizinho(destino, val);
    }

    public List<GraphLocalidade> getNodes() {
        return nodes;
    }
}
