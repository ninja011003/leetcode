import java.util.HashMap;
import java.util.Scanner;

public class PlaceFinder {
    static int n;
    static HashMap<Integer, Integer> noDevices = new HashMap<>();
    static HashMap<Integer, double[]> positions = new HashMap<>();
    static HashMap<Integer, int[][]> data = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine(); 

        String line = sc.nextLine();
        String[] lineArray = line.split(" ");
        for (String ele : lineArray) {
            String[] deviceInfo = ele.split(":");
            int deviceID = Integer.parseInt(deviceInfo[0]);
            int deviceCount = Integer.parseInt(deviceInfo[1]);
            noDevices.put(deviceID, deviceCount);
        }

        for (int ele : noDevices.keySet()) {
            int current = sc.nextInt();
            for (int i = 0; i < noDevices.get(ele); i++) {
                int[] temp = new int[3];
                for (int j = 0; j < 3; j++) {
                    temp[j] = sc.nextInt();
                }
                if (!data.containsKey(ele)) {
                    data.put(ele, new int[noDevices.get(ele)][3]);
                }
                data.get(ele)[i] = temp;
            }
        }

        int[] t = new int[2];
        t[0] = sc.nextInt();
        t[1] = sc.nextInt();

        positions.put(1, new double[]{0, 0});
        pos(1);

        double result = Math.sqrt(Math.pow(positions.get(t[0])[0] - positions.get(t[1])[0], 2) +
                                  Math.pow(positions.get(t[0])[1] - positions.get(t[1])[1], 2));
        System.out.printf("%.2f", result);
    }

    static void pos(int src) {
        if (positions.size() == n) {
            return;
        }
        if (!positions.containsKey(src)) {
            return;
        }
        while (data.get(src).length != 0) {
            int[] temp = data.get(src)[data.get(src).length - 1];
            int newDev = temp[0];
            int dis = temp[1];
            int ang = temp[2];
            if (!positions.containsKey(newDev)) {
                double x = positions.get(src)[0] + dis * Math.cos(Math.toRadians(ang));
                double y = positions.get(src)[1] + dis * Math.sin(Math.toRadians(ang));
                positions.put(newDev, new double[]{x, y});
                pos(newDev);
            }
            int[][] newData = new int[data.get(src).length - 1][3];
            System.arraycopy(data.get(src), 0, newData, 0, data.get(src).length - 1);
            data.put(src, newData);
        }
    }
}
