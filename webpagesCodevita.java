import java.util.ArrayList;
import java.util.Scanner;

public class webpagesCodevita {
    public static Scanner sc = new Scanner(System.in);
    public static int minDist = Integer.MAX_VALUE;
    public static ArrayList<ArrayList<Integer>> input;

    public static void pathComputer(int n, int start, int end, int dist) {
        if (dist > n)
            return;
        if (start == end) {
            if (dist < minDist) {
                minDist = dist;
            }
            return;
        } else {
            for (int i = 0; i < input.get(start - 1).size(); i++) {
                pathComputer(n, input.get(start - 1).get(i), end, dist + 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        sc.nextLine();
        input = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] numbersString = sc.nextLine().split(" ");

            ArrayList<Integer> numbers = new ArrayList<>();
            for (String num : numbersString) {
                numbers.add(Integer.parseInt(num));
            }

            input.add(numbers);
        }
        int start = sc.nextInt();
        int end = sc.nextInt();

        pathComputer(n, start, end, 0);
        if (minDist == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(minDist);
        }
    }
}
