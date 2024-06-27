public class sortedArray {

    public static String isSorted(int arr[],int i){
        if(i==arr.length-1){
            return "Array is sorted";
        }
        if(arr[i]>arr[i+1]){
            return "Array is not sorted";
        }
        return isSorted(arr, i+1);
        
    }
    public static void main(String[] args) {

        int arr[]={1,2,3,4,5};
        System.out.println(isSorted(arr, 0));
    }
}
