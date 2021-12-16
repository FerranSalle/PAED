import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    /*public static  ArrayList<Integer> bucketSort(ArrayList<Integer> numbers, int n){
        int decimalsZero;
        int caracter;
        float primer;
        float segon;
        int temp;
        ArrayList<Integer> b = new ArrayList<Integer>();

        // Crear buckets buits
        ArrayList<Integer>[] bucket = new ArrayList[10];
        for (int i = 0; i < 10; i++){
            bucket[i] = new ArrayList<Integer>();
        }

        decimalsZero = 0;

        // Afegir elements als buckets
        for (int j = 0; j < numbers.size(); j++ ) {
            if (n == 2) n++; //es el punt del float
            if (numbers.get(j) > n ) {
                caracter = numbers.get(j);
                bucket[caracter].add(numbers.get(j));
                decimalsZero = 1; //per acabar el programa necessitem que tots els decimals siguin 0
            } else {
                bucket[0].add(numbers.get(j));
            }
        }

        for (int i = 0; i < 10; i++) {
            if (bucket[i].size() > 2 && decimalsZero == 1) {
                bucket[i] = bucketSort(bucket[i],n + 1);
            } else if (bucket[i].size() == 2) {
                primer = Float.parseFloat(String.valueOf(bucket[i].get(0)));
                segon = Float.parseFloat(String.valueOf(bucket[i].get(1)));
                if (primer > segon) {
                    temp = bucket[i].get(0);
                    bucket[i].set(0,  bucket[i].get(1));
                    bucket[i].set(1,  temp);
                }
            }
        }

        // Obtenim el array ordenat
        for (int i = 0; i < 10; i++) {
            if(bucket[i].size() != 0){
                b.addAll(bucket[i]);
            }
        }
        return b;
    }*/

    // Function to sort arr[] of size n
    // using bucket sort
    static void bucketSort(ArrayList<Float> arr, int n) {
        if (n <= 0)
            return;

        // 1) Create n empty buckets
        @SuppressWarnings("unchecked")
        ArrayList<Float>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 2) Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            float idx = arr.get(i) / n;
            buckets[(int) idx].add(arr.get(i));
        }

        // 3) Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
            //bucketSort(buckets[i], n);
        }

        // 4) Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr.set(index++, buckets[i].get(j));
                //arr[index++] = buckets[i].get(j);
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Float> arr = new ArrayList<Float>();
        float[] a = {(float) 1.897, (float) 4.565,
                (float) 2.656, (float) 1.1234,
                (float) 2.665, (float) 3.3434};
        for (float n : a) {
            arr.add(n);
        }
        bucketSort(arr, arr.size());
        for (float f : arr) {
            System.out.println("num: " + f);
        }

    }
}
