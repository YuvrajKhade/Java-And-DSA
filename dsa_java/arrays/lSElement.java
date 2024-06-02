package dsa_java.arrays;

public class lSElement {
    public static int largeSmall(int arr[]){
        int largest=Integer.MIN_VALUE;
        int smallest=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(largest<arr[i]){
                largest=arr[i];
            }
            if (smallest>arr[i]) {
                smallest=arr[i];
            }
        }
        System.out.println("Smallest no. is "+smallest);
        return largest;
        
    }
    public static void main(String[] args) {
        int arr[]={34,21,33,4,5,6,79,8,9};
        System.out.println("Largest no. is: "+largeSmall(arr));
    }
}
