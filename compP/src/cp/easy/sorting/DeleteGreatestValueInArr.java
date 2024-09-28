package cp.easy.sorting;

public class DeleteGreatestValueInArr {
    public static void main(String[] args) {
        int[][] arr = {{35,52,74,92,25},{65,77,1,73,32},{43,68,8,100,84},{80,14,88,42,53},{98,69,64,40,60}};
        deleteGreatestValue(arr);
    }

    public static int deleteGreatestValue(int[][] grid) {
        for(int[] row : grid){
            sort(row,0,row.length-1);
            System.out.println("vfv");
        }
        int sum = 0;
        for(int i = grid[0].length-1; i>=0;i--){
            int max = 0;
            for(int[] row : grid){
                max = Math.max(row[i],max);
            }
            sum += max;
        }
        return sum;
    }

    public static void sort(int[] arr,int low,int high){
        if(low < high){
            int mid = low + (high-low)/2;
            sort(arr,low,mid);
            sort(arr,mid+1,high);
            mergeSort(arr,low,mid,high);
        }
    }

    public static void mergeSort(int[] arr,int low,int mid,
                                 int high){
        int leftSize = mid-low+1;
        int rightSize = high-mid;
        int[] L = new int[leftSize];
        int[] R = new int[rightSize];
        for(int i = 0;i<leftSize;i++){
            L[i] = arr[low+i];
        }

        for(int j = 0; j<rightSize;j++){
            R[j] = arr[j+mid+1];
        }

        int i=0;
        int j = 0;
        int k = low;
        while(i < leftSize && j < rightSize){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i < leftSize){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < rightSize){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
