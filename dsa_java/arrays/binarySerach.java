package dsa_java.arrays;

public class binarySerach {
    public static int binary(int arr[],int key){
           int start=0, last=arr.length-1;
           while(start<=last){

            int mid= (start+last)/2;

            if(arr[mid]==key){
                return mid;
            }
            else if (arr[mid]>key) {
                last=mid-1;
            } else {
                start=mid+1;
            }

           }
           return -1;
    }
       
        
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        int key=4;
        System.out.println(binary(arr,key));
    }
}
