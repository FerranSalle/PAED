package edu.salleurl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

// Classe auxiliar que representa una configuració per a facilitar la implementació de l'algorisme BnB
public class TSPConfig implements Comparable<TSPConfig> {
    // La configuració (representa l'ordre en que visitem les ciutats)
    private final int[] config;
    // L'array de marcatge per ciutats visitades
    private final boolean[] visited;
    // El marcatge per la distància total viatjada
    private int dist;
    // El nivell en el que ens trobem
    private int k;

    // Constructor per defecte,inicialitzarà la primera configuració
    public TSPConfig() {
        // Creem els arrays
        config = new int[Globals.N];
        visited = new boolean[Globals.N];

        // Comencem a la primera ciutat
        k = 1;
        config[0] = Globals.START;
        visited[Globals.START] = true;

        // No hem acumulat distància encara
        dist = 0;
    }

    // Constructor auxiliar (privat) per "clonar" una configuració, fet servir per generar successors al "expandir"
    private TSPConfig(TSPConfig that) {
        this.config = that.config.clone();
        this.visited = that.visited.clone();
        this.dist = that.dist;
        this.k = that.k;
    }

    // Funció que "expandeix" la configuració actual, retornant els seus successors com una arrayList
    public Iterable<TSPConfig> expandir() {
        Collection<TSPConfig> successors = new ArrayList<>();

        // Per cada possible ciutat a visitar com a successor
        for (int i = 0; i < Globals.N; i++) {
            // Ignorant les ciutats que ja hem visitat
            if (!visited[i]) {
                // Clonem la configuració actual amb el constructor vist prèviament
                TSPConfig successor = new TSPConfig(this);

                // Incrementem el nivell (ja que és un successor)
                successor.k++;

                // Actualitzem la configuració + marcatge segons la ciutat escollida
                successor.config[k] = i;
                successor.visited[i] = true;
                successor.dist += Globals.DIST[successor.config[k]][successor.config[k - 1]];

                // Afegim el successor a la llista
                successors.add(successor);
            }
        }

        return successors;
    }

    // Funció auxiliar per saber si la configuració és solució (per com generem el valor k, en aques cas comparem amb N i no N-1)
    public boolean esSolucio() {
        return k == Globals.N;
    }

    // Funció auxiliar per debugar / veure què fa l'algorisme
    public void mostra() {
        System.out.println(Arrays.toString(config) + " k:" + k + ", dist: " + cost());
    }

    // Funció auxiliar que retorna el cost per la configuració actual (tenint en compte que un cop escollit l'ordre de les N ciutats cal tornar a l'inici)
    public int cost() {
        return dist + (esSolucio() ? Globals.DIST[config[k - 1]][config[0]] : 0);
    }

    // Funció auxiliar que estima (aproxima) el cost total d'una configuració parcial
    private int estimacio() {
        // Prenem un enfoc optimista, assumint que independentment del camí que escollim ens mourem sempre amb el mínim cost possible,
        // concretament completem el cost actual amb la suma dels costs mínims de les ciutats que queden (incloent tornar a l'inici)
        int estimat = dist;

        // Per cada ciutat no-visitada (i tornar a l'inici) assumim que el cost serà el mínim
        for (int i = 0; i < Globals.N; i++) {
            if (!visited[i]) {
                estimat += Globals.MINIMS[i];
            }
        }
        estimat += Globals.MINIMS[Globals.START];

        return estimat;
    }

    // Funció compareTo de la interfície Comparable, que la priority queue de Java fa servir internament per ordenar els elements
    @Override
    public int compareTo(TSPConfig that) {
        // Comparem costos estimats
        return this.estimacio() - that.estimacio();
    }
}
