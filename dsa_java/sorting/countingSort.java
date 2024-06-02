package dsa_java.sorting;

public class countingSort {

    public static void sort(int arr[]){
        int largest=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest=Math.max(largest, arr[i]);
        }

        int count[]=new int[largest+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }

        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }
    public static void print(int arr[]){
        // System.out.println("Sorted array by bubble sort: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]={2,5,4,4,2,7,1};
        System.out.println("array before sort: ");
        print(arr);
        sort(arr);
        System.out.println("Array after sort: ");
        print(arr);
    }
}
