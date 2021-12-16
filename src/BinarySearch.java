public class BinarySearch {
    /**
     * Serca binaria
     *
     * @param arr array de int
     * @param x   número que vols buscar
     * @param l   inici pos dreta on vols començar a buscar
     * @param r   final esquerra on vols començar a buscar
     * @return Retorna la posició on es troba el número
     */
    public static int binarySearch(int[] arr, int x, int l, int r) {
        if (l == r) {
            if (arr[l] == x) {
                return l;
            }
            return -1;
        }
        int mid = (l + r) / 2;
        if (x < arr[mid]) {
            return binarySearch(arr, x, l, mid - 1);
        } else if (x > arr[mid]) {
            return binarySearch(arr, x, mid + 1, r);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 10, 32, 23, 52, 124, 1234, 5000, 6000};
        System.out.println(binarySearch(arr, 23, 0, arr.length - 1));
    }
}
