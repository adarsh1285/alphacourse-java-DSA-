public class MergeSort {
    public static void printArr(int arr[]) {
        for(int i = 0; i<=arr.length-1; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int si , int ei){
        // base case 
        if (si >= ei){
            return;
        }
        //kaam 
        int mid = (si + ei)/2; //si+ei/2;
        mergeSort(arr, si, mid);  // left merge call
        mergeSort(arr, mid+1, ei);  // right merge call
        merge(arr, si , mid , ei);
    }

    public static void merge(int arr[], int si, int mid , int ei){
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;
        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            }else{
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        //if left part is remaining'\
        while(i <= mid){
            temp[k++] = arr[i++];
            
        }
        // if right part is remaining
        while(j <= ei){
            temp[k++] = arr[j++];
        }
        // copy temp to original arr
        for(k = 0 , i = si; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        printArr(arr);
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);

    }
}
