package dsa_java.arrays;

public class subArrays {
    public static void subarr(int arr[]){
        int tc=0;
        int minval=Integer.MAX_VALUE;
        int maxval=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum=0;
                for (int j2 = i; j2 <= j; j2++) {
                    System.out.print(arr[j2]+" ");
                    sum+=arr[j2];
                    
                }
                System.out.print("Sum is: "+sum);
                System.out.println();
                tc++;

                //compare for max and min sum
                if(maxval<sum){
                    maxval=sum;
                }
                if(minval>sum){
                    minval=sum;
                }
        
            }
            System.out.println();
        }
        System.out.println("Overall...");
        System.out.println("Maximum sum: "+maxval);
        System.out.println("Minimum sum: "+minval);
        System.out.println("Total sub arrays: "+tc);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        subarr(arr);
    }
}
