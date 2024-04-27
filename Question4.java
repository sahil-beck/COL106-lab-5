import java.util.Vector;

public class Question4 {
    private static void merge (int l, int m, int r, Vector<int[]> bucket) {
        int p = m + 1 - l, q = r - m;
        Vector<int[]> left = new Vector<>(), right = new Vector<>();
        for (int i = l; i <= m; i++) left.add(bucket.get(i));
        for (int i = m + 1; i <= r; i++) right.add(bucket.get(i));
        int i = 0, j = 0, k = l; 
        while (i < p || j < q) {
            if (i < p && j < q) {
                if (left.get(i)[0] <= right.get(j)[0]) {
                    bucket.set(k, left.get(i));
                    i++;
                }
                else {
                    bucket.set(k, right.get(j));
                    j++;
                }
            }
            else if (i < p) {
                bucket.set(k, left.get(i));
                i++;
            }
            else {
                bucket.set(k, right.get(j));
                j++;
            }
            k++;
        }
    }

    private static void mergeSort (int l, int r, Vector<int[]> bucket) {
        if (l >= r) return;
        int m = l + (r - l) / 2;
        mergeSort(l, m, bucket);
        mergeSort(m + 1, r, bucket);
        merge(l, m, r, bucket);
    }

    private static void bucketSort (int arr[][]) {
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] > n) n = arr[i][0];
        }
        Vector<Vector<int[]>> buckets = new Vector<>();
        for (int i = 0; i <= n; i++) buckets.add(new Vector<>());
        for (int i = 0; i < arr.length; i++) buckets.get(arr[i][0]).add(arr[i]);
        for (int i = 0; i <= n; i++) mergeSort(0, buckets.get(i).size() - 1, buckets.get(i));
        for (int i = 0, j = 0; j <= n; j++) {
            for (int k = 0; k < buckets.get(j).size(); k++, i++) arr[i] = buckets.get(j).get(k);
        }
    }

    private static void output (int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // test cases 
        int arr[][] = {{2, 4}, {2, 6}, {1, 10}, {1, 5}, {1, 7}}; // TC1
        // int arr[][] = {{50, 20}, {10, 30}, {20, 40}, {50, 10}, {10, 20}, {15, 25}}; // TC2
        bucketSort(arr);
        output(arr);
    }
}
