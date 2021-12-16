import java.util.Arrays;

/**
 * Tenim unes quantes ciutats i volem recorreles totes en el mínim de temps posible
 */
public class TravellingSalesmanProblem {
    public static final int[][] distancies = {{0, 51, 33, 30, 38}, {51, 0, 47, 31, 83}, {33, 47, 0, 48, 70}, {30, 31, 48, 0, 53}, {38, 83, 70, 53, 0}};
    private static final int n = distancies.length;

    public static void main(String[] args) {
        Arrays.fill(visited, false);
        int config[] = new int[distancies.length];
        config[0] = 0;
        bruteForce(config, 1);
        currentDist = 0;
    }

    private static int currentDist;
    private static boolean[] visited = new boolean[distancies.length];

    public static void bruteForce(int[] config, int k) {
        config[k] = 0;
        while (config[k] < n) {
            currentDist += distancies[config[k]][config[k - 1]];
            if (!visited[config[k]]) {
                visited[config[k]] = true;
                if (k == n - 1) {
                    //process solution
                    checkSolution(config);
                } else {
                    if (currentDist < bestDistance) {
                        //if (potencialBest(config, k)){
                        bruteForce(config, k + 1);

                    }

                }
                visited[config[k]] = false;

            }
            currentDist -= distancies[config[k]][config[k - 1]];

            config[k]++;
        }
    }

    private static boolean potencialBest(int[] config, int k) {
        int dist = 0;
        for (int i = 1; i < k; i++) {
            dist += distancies[config[i - 1]][config[i]];
        }
        return dist < bestDistance;
    }

    private static boolean correct(int[] config, int k) {
        for (int i = 0; i < k; i++) {
            if (config[i] == config[k]) {
                return false;
            }
        }
        return true;
    }

    private static int bestDistance = Integer.MAX_VALUE;

    private static void checkSolution(int[] config) {
        /*for (int i = 0; i < config.length; i++) {
            for (int j = 0; j < config.length; j++) {
                if (config[i] == config[j] && i != j) {
                    return;
                }
            }
        }*/
        /*int dist = 0;
        for (int i = 1; i < config.length; i++) {
            dist += distancies[config[i - 1]][config[i]];
        }
        dist += distancies[config[0]][config[n - 1]];*/
        if (currentDist < bestDistance) {
            bestDistance = currentDist;
            System.out.println(Arrays.toString(config));
            System.out.println(bestDistance);
        }
    }
}
