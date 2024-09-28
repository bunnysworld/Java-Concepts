package cp.easy.sorting;

public class sortingTheSentence {
    public static void main(String[] args) {
        sortSentence("is2 sentence4 This1 a3");
    }

    public static String sortSentence(String s) {
        String[] arr = s.split(" ");
        quickSort(arr, 0, arr.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length-1; i++) {
            sb.append(arr[i].substring(0, arr[i].length() - 1)+" ");
        }
        sb.append(arr[arr.length-1].substring(0,arr[arr.length-1].length()-1));
        return sb.toString();
    }

    public static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(String[] arr, int low, int high) {
        char pivot = arr[high].charAt(arr[high].length() - 1);
        int k = low;
        for (int i = low; i < high; i++) {
            if (arr[i].charAt(arr[i].length() - 1) < pivot) {
                String tmp = arr[i];
                arr[i] = arr[k];
                arr[k] = tmp;
                k++;
            }
        }
        String tmp = arr[high];
        arr[high] = arr[k];
        arr[k] = tmp;
        return k;
    }
}
