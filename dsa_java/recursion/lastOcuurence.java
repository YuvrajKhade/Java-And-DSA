package dsa_java.recursion;

public class lastOcuurence {

    public static int isLast(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        int isfound=isLast(arr, key, i+1);
        if(isfound==-1 && arr[i]==key){
            return i;
        }
        return isfound;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,5,6,7,5};
        int key=5;
        System.out.println("Last occurence of element: "+isLast(arr, key, 0));

    }
}
