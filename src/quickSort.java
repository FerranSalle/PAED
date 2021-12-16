import java.util.Arrays;

public class quickSort {

    public static void quickSort(int[] arr, int i, int j) {
        if (i >= j) {
            System.out.println(Arrays.toString(arr));
        } else {
            int p = particio(arr, i, j);
            quickSort(arr, i, p);
            quickSort(arr, p + 1, j);
        }
    }

    public static int particio(int[] arr, int i, int j) {
        int l = i;
        int r = j;
        int mig = (i + j) / 2;
        int pivot = arr[mig];
        while (true) {
            while (arr[l] < pivot) {
                l = l + 1;
            }
            while (arr[r] > pivot) {
                r = r - 1;
            }
            if (l >= r) {
                return r;
            }
            int swap = arr[l];
            arr[l] = arr[r];
            arr[r] = swap;
            l = l + 1;
            r = r - 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 3, 7, 11, 8};
        quickSort(arr, 0, arr.length - 1);

    }
}
