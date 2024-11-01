
import java.util.*;
public class Main {
    public static void mountArray(int arr[])
    {
        int N = arr.length;
        int left[] = new int[N];
        int right[] = new int[N];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[j] < arr[i]) {
                    left[i] = Math.max(left[j]
                                    + 1,
                            left[i]);
                }
            }
        }

        for (int i = N - 1; i >= 0; --i) {
            for (int j = i; j <= N - 1; ++j) {
                if (arr[j] < arr[i]) {
                    right[i]
                            = Math.max(right[j]
                                    + 1,
                            right[i]);
                }
            }
        }
        int max = 0;
        int index = 0;
        for (int i = 1; i < N - 1; ++i) {
            if (left[i] != 1 && right[i] != 1) {

                if (max < (left[i] + right[i]) - 1) {
                    index = i;
                    max = (left[i] + right[i]) - 1;
                }
            }
        }

        ArrayList<Integer> left1 = new ArrayList<Integer>();
        left1.add(arr[index]);
        for (int i = index; i >= 0; --i) {
            if (arr[i] < arr[index]) {
                if (left[i] + 1 == left[index]) {
                    left1.add(arr[i]);
                    left[index] -= 1;
                }
            }
        }

        ArrayList<Integer> right1 = new ArrayList<>();
        for (int i = index; i < right.length; ++i) {
            if (arr[index] > arr[i]) {

                if (right[i] + 1
                        == right[index]) {
                    right1.add(arr[i]);
                    right[index] -= 1;
                }
            }
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = {2,1,1,5,6,2,3,1};
        mountArray(arr);
    }

}