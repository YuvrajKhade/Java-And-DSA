package dsa_java.arrays;
public class sumSubArray {
    public static void sumsubarray(int arr[]){
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                System.out.println("sum is: "+sum);
                if(max<sum){
                    max=sum;
                }
            }
            
            
        }
        System.out.println("Maximum sum of subarray: "+max);
        
    }
    public static void main(String[] args) {
        //int arr[]={1,2,3,4,-2,-3};
        int arr[]={2,4,6,8,10};
        sumsubarray(arr);
    }
}
//time complexiety is O(n^3)