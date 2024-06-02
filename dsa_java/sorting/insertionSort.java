package dsa_java.sorting;

public class insertionSort {

    public static void sort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int cur=arr[i];
            int prev=i-1;
            while (prev>=0 && arr[prev]>cur) {

                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=cur;
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
        int arr[]={4,5,3,7,2,6};
        System.out.println("array before sort: ");
        print(arr);
        sort(arr);
        System.out.println("Array after sort: ");
        print(arr);
    }
}
//O(n^2)