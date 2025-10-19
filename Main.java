import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        try {
            n = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return;
        }

        String[] products = new String[n];
        for (int i = 0; i < n; i++) {
            products[i] = sc.nextLine();
        }

        if (n > 0) {
            String[] aux = new String[n];
            mergeSort(products, aux, 0, n - 1);
        }

        System.out.println("\nSorted shopping list:");
        for (String p : products) {
            System.out.println(p);
        }
    }

    private static void mergeSort(String[] arr, String[] aux, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, aux, left, mid);
        mergeSort(arr, aux, mid + 1, right);
        merge(arr, aux, left, mid, right);
    }

    private static void merge(String[] arr, String[] aux, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            int cmp = compareCaseInsensitive(arr[i], arr[j]);
            if (cmp <= 0) { 
                aux[k++] = arr[i++];
            } else {
                aux[k++] = arr[j++];
            }
        }

        while (i <= mid) aux[k++] = arr[i++];

        while (j <= right) aux[k++] = arr[j++];

        for (k = left; k <= right; k++) arr[k] = aux[k];
    }

    private static int compareCaseInsensitive(String a, String b) {
        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;
        return a.compareToIgnoreCase(b);
    }
}