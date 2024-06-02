package dsa_java.arrays;

public class rainWaterTrapped {

    public static int trap(int arr[]){

        int n=arr.length;
        int leftArray[]=new int[n];
        int rigthArray[]=new int[n];

        leftArray[0]=arr[0];
        for(int i=1;i<n;i++){

            leftArray[i]=Math.max(arr[i], leftArray[i-1]);
        }
        rigthArray[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            rigthArray[i]=Math.max(arr[i], rigthArray[i+1]);
        }

        int trappedWater=0;
        for(int i=0;i<n;i++){
            int waterLevel=Math.min(leftArray[i], rigthArray[i]);

            trappedWater+=waterLevel-arr[i];
        }

        return trappedWater;
    }
    public static void main(String[] args) {
        int arr[]={4,2,0,6,3,2,5};
        System.out.println("Total traped Water: "+trap(arr));
    }
}
