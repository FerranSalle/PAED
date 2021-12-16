package edu.salleurl;

import java.util.PriorityQueue;


public class Main {

    // Mètode principal, on implementarem l'algorisme Branch and Bound. Com que és iteratiu (no recursiu),
    // no ens cal un mètode extra
    public static void main(String[] args) {
        // Iniciaització de l'array de distàncies mínimes
        Globals.init();

        // Distància més baixa (cost de la millor configuració), comença a "infinit" - Per optimitzar
        int millor = Integer.MAX_VALUE;

        // Priority Queue (Cua de prioritat) que farem servir per navegar l'espai de solucions de forma "dinàmica"
        // A Java, la PriorityQueue fa servir la interfície Comparable per ordenar els seus elements
        PriorityQueue<TSPConfig> cua = new PriorityQueue<>();

        // Creem la configuració inicial i l'encuem
        TSPConfig primera = new TSPConfig();
        cua.offer(primera);

        // Repetim el següent procés fins que no quedin més configuracions a considerar
        while (!cua.isEmpty()) {
            // Agafem la primera configuració de la cua (major prioritat / menor cost estimat)
            TSPConfig config = cua.poll();

            // L'expandim, obtenint els successors
            Iterable<TSPConfig> successors = config.expandir();

            // Per cadascun dels successors
            for (TSPConfig successor : successors) {

                // Si és solució (hem pres totes les decisions)
                if (successor.esSolucio()) {
                    // Mostrem les seves dades
                    successor.mostra();

                    // Procés d'optimització
                    if (successor.cost() < millor) {
                        millor = successor.cost();
                        System.out.println("El millor fins ara");
                    }
                } else {
                    // Si no és solució (encara queden decisions per prendre)
                    // PBMSC
                    if (successor.cost() < millor) {
                        // Afegim el successor a la cua, que farà servir el seu cost estimat per determinar quan explorar-lo
                        cua.offer(successor);
                    } else {
                        // Debugging comentat per evitar gastar més recursos del compte
                        //successor.mostra();
                        //System.out.println("PBMSC");
                    }
                }
            }
        }
    }
}
