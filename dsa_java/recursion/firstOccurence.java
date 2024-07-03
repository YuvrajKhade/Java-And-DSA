package dsa_java.recursion;

public class firstOccurence {

    public static int isFirst(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return isFirst(arr, key, i+1);
    }
    public static void main(String[] args) {
        int arr[]={2,4,1,8,5,6,9,5};
        int key=5;
        System.out.println("Key first occurence is: "+isFirst(arr, key, 0));
    }
}
