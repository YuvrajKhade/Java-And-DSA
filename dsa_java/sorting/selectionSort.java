package dsa_java.sorting;

public class selectionSort {

    public static void sort(int arr[]){

        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
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
        int arr[]={5,3,6,8,2,9};
        System.out.println("array before sort: ");
        print(arr);
        sort(arr);
        System.out.println("Array after sort: ");
        print(arr);
    }
}
//O(n^2) only extra swapping overhead is reduce