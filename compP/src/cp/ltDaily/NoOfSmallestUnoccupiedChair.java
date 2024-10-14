package cp.ltDaily;

import java.util.HashMap;
import java.util.Map;

public class NoOfSmallestUnoccupiedChair {
    public static void main(String[] args) {
        int[][] arr = {
                {98198, 99979},
                {94438, 98042},
                {6104, 64150},
                {15632, 17378},
                {6923, 88529},
                {68469, 98315},
                {37973, 86066},
                {90969, 99746},
                {92396, 96991},
                {53994, 66509},
                {92972, 97874},
                {70262, 84374},
                {50387, 64907},
                {99240, 99985},
                {25642, 56565},
                {7253, 9683},
                {43669, 68559},
                {60520, 85461},
                {96567, 97544},
                {64789, 83994},
                {73723, 84301},
                {55796, 58566},
                {67943, 78915},
                {92673, 94868},
                {53570, 58135},
                {69549, 78461},
                {17694, 75744},
                {9265, 77868},
                {57880, 89655},
                {23327, 80521},
                {91232, 91639},
                {91623, 92961},
                {49501, 88454},
                {88932, 91622},
                {54965, 59650},
                {46587, 60025},
                {45140, 98782},
                {47029, 90516},
                {28112, 29624},
                {73021, 83152},
                {5377, 19703},
                {70610, 72191},
                {40633, 66034},
                {87913, 98864},
                {35913, 50422},
                {39121, 93376},
                {21100, 79841},
                {8190, 68139},
                {5140, 54276},
                {22993, 62342},
                {3491, 8572},
                {70407, 81025},
                {81198, 96920},
                {29041, 31796},
                {77060, 81160},
                {94588, 97686}
        };
        smallestChair(arr, 50);
    }

    public static int smallestChair(int[][] times, int targetFriend) {
        int startTime = times[targetFriend][0];
        quickSort(times, 0, times.length - 1);
        if (times[0][0] == targetFriend) {
            return 0;
        }
        Map<Integer, int[]> map = new HashMap<>();
        map.put(0, times[0]);
        int lastSeat = 0;
        for (int i = 1; i < times.length; i++) {
            int[] currTime = times[i];
            int s = 0;
            while (s <= lastSeat) {
                int[] targetSeat = map.get(s);
                if (currTime[0] >= targetSeat[1]) {
                    map.put(s, currTime);
                    break;
                }
                s = s + 1;
            }
            if (currTime[0] == startTime) {
                return s;
            }
            if (!map.containsKey(s)) {
                lastSeat = s;
                map.put(s, currTime);
            }
        }
        return lastSeat;
    }

    public static void quickSort(int[][] times, int low, int high) {
        if (low < high) {
            int pi = partition(times, low, high);
            quickSort(times, low, pi - 1);
            quickSort(times, pi + 1, high);
        }
    }

    public static int partition(int[][] times, int low, int high) {
        int pivot = times[high][0];
        int k = low;
        for (int i = low; i < high; i++) {
            if (times[i][0] < pivot) {
                int[] tmp = times[k];
                times[k] = times[i];
                times[i] = tmp;
                k++;
            }
        }
        int[] tmp = times[high];
        times[high] = times[k];
        times[k] = tmp;
        return k;
    }
}
