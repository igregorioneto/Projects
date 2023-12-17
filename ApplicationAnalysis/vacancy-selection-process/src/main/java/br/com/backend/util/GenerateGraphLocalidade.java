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

    @PostConstruct
    public void init() {
        System.out.println("A classe GenerateGraphLocalidade foi inicializada ao iniciar o Spring Boot.");

        GraphLocalidade nodeA = new GraphLocalidade(Localidade.A);
        GraphLocalidade nodeB = new GraphLocalidade(Localidade.B);
        GraphLocalidade nodeC = new GraphLocalidade(Localidade.C);
        GraphLocalidade nodeD = new GraphLocalidade(Localidade.D);
        GraphLocalidade nodeE = new GraphLocalidade(Localidade.E);
        GraphLocalidade nodeF = new GraphLocalidade(Localidade.F);

        nodeA.addVizinho(nodeB, 5);
        nodeB.addVizinho(nodeC, 7);
        nodeB.addVizinho(nodeD, 3);
        nodeC.addVizinho(nodeB, 7);
        nodeC.addVizinho(nodeE, 4);
        nodeD.addVizinho(nodeB, 3);
        nodeD.addVizinho(nodeF, 8);
        nodeE.addVizinho(nodeC, 4);
        nodeE.addVizinho(nodeD, 10);
        nodeF.addVizinho(nodeD, 8);

        System.out.println("Vizinhos de B");
        for (Map.Entry<GraphLocalidade, Integer> vizinho:nodeB.vizinhos.entrySet()) {
            System.out.print(vizinho.getValue() + " ");
        }

        System.out.println("Local B ao E");
        GraphLocalidade.percorrerLocais(nodeB, nodeE);
        for (Localidade e:GraphLocalidade.caminho) {
            System.out.print(e.getLocalidade() + " ");
        }
    }
}
