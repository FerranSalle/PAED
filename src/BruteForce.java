import java.util.Arrays;

public class BruteForce {
    private static int[] numbers = new int[]{-7, -5, 3, -2, 11, -1, 2, 1, -6};
    private static int limit = 25;
    private static int bestConfig = 0;

    public static void main(String[] args) {
        int[] config = new int[numbers.length];

        // Just for illustration purposes when debugging step by step
        Arrays.fill(config, -1);

        bruteForce(config, 0);
    }

    private static void bruteForce(int[] config, int k) {
        config[k] = 0;

        while (config[k] <= 1) {
            if (k < config.length - 1) {
                bruteForce(config, k + 1);
                System.out.println(Arrays.toString(config));
            } else {
                // Solution case
                //checkSolution(config);
            }

            // Next successor
            config[k]++;
        }
    }

    private static boolean checkValid(int[] config, int k) {
        int totalWeight = 0;
        for (int i = 0; i < config.length - 1; i++) {
            //TODO Baixar codi estudy
        }
        boolean a = true;
        return a;
    }

    private static void checkSolution(int[] config) {
        int sum = 0;
        for (int i = 0; i < config.length; i++) {
            sum += numbers[i] * config[i];
        }

        if (sum == limit) {
            System.out.println("Numbers that add up to 0:");

            for (int i = 0; i < config.length; i++) {
                if (config[i] == 1) {
                    System.out.println(numbers[i]);
                }
            }
        }
    }
}
