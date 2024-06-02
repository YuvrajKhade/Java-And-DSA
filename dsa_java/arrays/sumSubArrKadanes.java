package dsa_java.arrays;

public class sumSubArrKadanes {
    public static void kadanes(int arr[]){
        int current=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){

            current=current+arr[i];
            
            if(current<0){
                current=0;  
            }
            max=Math.max(current,max);
        }
        System.out.println("Maximum sum is: "+max);
    }
    public static void main(String[] args) {
        int arr[]={-2,-3,4,1,-2,-1,5,-3};
        //we sepcify below code for the array which containing all elements are negative
        boolean allNegative = true;
        int maxElement = arr[0];
        for (int num=0;num<arr.length;num++) {
            if (arr[num] >= 0) {
                allNegative = false;
                break;
            }
            if (arr[num] > maxElement) {
                maxElement = arr[num];
            }
        }

        // If all elements are negative, the maximum sum is the largest element
        if (allNegative) {
            System.out.println("Maximum sum is: " + maxElement);
        } else {
            // Otherwise, run Kadane's algorithm
            kadanes(arr);
        }
    }
}
//time complexiety O(n) more optimized code