import java.util.Arrays;

//TODO fixar bucle infinit
public class mSort {
    public static int[] mergeSort(int[] a, int i, int j) {
        if (i >= j) {
            return a;
        } else {
            int mig = (i + j) / 2;
            a = mergeSort(a, i, mig);
            a = mergeSort(a, mig + 1, j);
            a = merge(a, i, mig, j);
            return a;
        }
    }

    public static int[] merge(int[] a, int i, int mig, int j) {
        int l = i;
        int r = mig + 1;
        int cursor = i;
        int[] b = new int[a.length];
        while (l <= mig && r <= j) {
            if (a[l] <= a[r]) {
                b[cursor] = a[l];
                l++;
                cursor++;
            } else {
                b[cursor] = a[r];
                r++;
                cursor++;
            }
        }
        while (l <= mig) {
            b[cursor] = a[l];
            l++;
            cursor++;
        }
        while (r <= j) {
            b[cursor] = a[r];
            r++;
            cursor++;
        }

        int k = i;
        while (k <= j) {
            a[k] = b[k];
            k++;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 3, 7, 11, 8};
        System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
    }
}
