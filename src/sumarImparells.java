public class sumarImparells {
    public static int sumImparells(int x) {
        if (x > 0) {
            if (x % 2 == 1) return x + sumImparells(x - 2);
            else {
                return sumImparells(x - 2);
            }

        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int x = 7;
        System.out.println(sumImparells(x));


    }
}
