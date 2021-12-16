import java.util.Arrays;

public class Reinas {
    public static void main(String[] args) {
        int n = 5;
        // La configuració representa a quina columna va cada reina, assumint que a cada fila només n'hi haurà una
        int[] config = new int[n];

        // Ens guardem el moment en el que hem començat l'execució (per mesurar quant triga)
        long t = System.currentTimeMillis();

        // Cridem l'algorisme de backtracking amb el nivell inicial (0)
        backtracking(config, 0, n);

        // Mostrem quants segons ha trigat l'execució
        System.out.println((System.currentTimeMillis() - t) / 1000.0f);
    }

    // Algorisme per resoldre el problema de les n reines amb força bruta, li passem la configuració actual, el nivell al que estem
    // i la variable "n" del problema (tot i que podem fer servir la llargada de l'array)
    private static void backtracking(int[] config, int k, int n) {
        // preparaNivell
        config[k] = 0;

        // Mentre hiHaSuccessor
        while (config[k] < n) {
            if (k == n - 1) {
                // Cas solució
                // Comprovem les restriccions del problema
                if (correcta(config, k)) {
                    printaTaulell(config, n);
                }
            } else {
                // Cas no-solució
                // Comprovem les restriccions del problema, podant les configuracions que ja sabem que no es poden completar
                if (correcta(config, k)) {
                    // Crida recursiva
                    backtracking(config, k + 1, n);
                }
            }

            // següentSuccessor
            config[k]++;
        }
    }

    // Funció correcta per comprovar si una configuració encara segueix les normes del problema
    // Es pot fer servir tant com a "factible" (per solucions - és a dir, configuracions plenes) o "completable" (per la resta)
    // Un detall important és que com que ja realitzem comprovacions a cada nivell, podem asumir que les reines anteriors ja compleixen
    // les restriccions del problema, i per tant només cal comprovar la que acabem de posar (k)
    private static boolean correcta(int[] config, int k) {
        for (int i = 0; i < k; i++) {
            // La nova reina no pot estar estar a la mateixa columna que una altra
            if (config[i] == config[k]) {
                return false;
            }

            // La nova reina no pot estar estar a la mateixa diagonal que una altra
            if (Math.abs(config[i] - config[k]) == Math.abs(i - k)) {
                return false;
            }
        }

        return true;
    }

    // Funció auxiliar per printar la solució com a taulell amb reines
    private static void printaTaulell(int[] config, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (config[i] == j) {
                    System.out.print("♕");
                } else {
                    System.out.print("□");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(Arrays.toString(config));
    }
}
