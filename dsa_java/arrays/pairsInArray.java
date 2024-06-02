package dsa_java.arrays;

public class pairsInArray {
    public static void pair(int arr[]){
        int tc=0;
        for(int i=0;i<=arr.length-1;i++){
            for(int j=i+1;j<=arr.length-1;j++){
                System.out.print("("+arr[i]+","+arr[j]+") ");
                tc++;
            }
            System.out.println();
        }
        System.out.println("Total pairs are: "+tc);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        pair(arr);

    }
}
