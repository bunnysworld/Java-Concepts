package cp.easy.sorting;

import java.util.ArrayList;
import java.util.List;


public class MatrixCellDist {

    public static void main(String[] args) {
        int[][] ans = allCellsDistOrder(2, 2, 0, 1);
        System.out.println(ans);
    }

    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        List<int[]> ans = new ArrayList<>();
        int[] distance = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans.add(new int[]{i, j});
                distance[index] = Math.abs(i - rCenter) + Math.abs(j - cCenter);
                index++;
            }
        }
        insertionSort(distance, ans);
        return ans.toArray(int[][]::new);
    }

    public static void insertionSort(int[] dist, List<int[]> ans) {
        for (int i = 0; i < dist.length; i++) {
            int minIndex = i;
            for (int j = i; j < dist.length; j++) {
                if (dist[j] < dist[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = dist[i];
            dist[i] = dist[minIndex];
            dist[minIndex] = tmp;

            int[] t = ans.get(i);
            ans.set(i, ans.get(minIndex));
            ans.set(minIndex, t);
        }
    }
}
