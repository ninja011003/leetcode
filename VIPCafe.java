import java.util.Scanner;

public class VIPCafe {
    public static int placementlelo(int[] arr, int pos) {
        int in = -1;
        int maxi = -1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (maxi < arr[i]) {
                in = i;
                maxi = arr[i];
            }
        }
        if (in == pos) return 0;
        arr[in] = -1;

        for (int i = 0; i < in; i++) {
            if (arr[i] > 0) arr[i]++;
        }

        return 1 + placementlelo(arr, pos);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        k--;
        System.out.print(1 + placementlelo(arr, k));
        scanner.close();
    }
}

