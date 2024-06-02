package dsa_java.sorting;

public class bubbleSort {
    
    public static void sort(int arr[]){

        for(int i=0;i<arr.length-1;i++){
            boolean status=false;//this define becoz when array is already sort
            for(int j=0;j<arr.length-i-1;j++){
                
                if(arr[j]>arr[j+1]){
                    status=true;
                    int temp;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if (status == false) {
                break;
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

        int arr[]={1,2,3,4,5};

        System.out.print("Array before sort ");
        print(arr);

        sort(arr);
        System.out.print("Array after sort ");
        print(arr);
    }
}
