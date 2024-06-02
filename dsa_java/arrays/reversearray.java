package dsa_java.arrays;

public class reversearray {
    public static void reverse(int arr[]){
        int s=0,e=arr.length-1;
        while(s<e){
            int temp;
            temp=arr[e];
            arr[e]=arr[s];
            arr[s]=temp;

            s++;
            e--;
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        reverse(arr);
        System.out.println("Reversed array");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }
}
//not optimize code becoz of space complexity
/* 
public static void reverse(int arr[]){
    int narr[]=new int[arr.length];
    int j=0;
    for(int i=arr.length-1; i>=0;i--){
        narr[j]=arr[i];
        j++;
    }
    for (int i = 0; i < narr.length; i++) {
        System.out.print(narr[i]+" ");
    }
}
public static void main(String[] args) {
    int arr[]={1,2,3,4,5,6};
    reverse(arr);

}*/