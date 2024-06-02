package dsa_java.arrays;

public class sumSubArrPrefix {
    public static void prefix(int arr[]){
        int sum=0;
        int max=Integer.MIN_VALUE;
        int pref[]=new int[arr.length];

        pref[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            pref[i]=pref[i-1]+arr[i];
        }

        for(int i=0;i<pref.length;i++){
            for(int j=i;j<pref.length;j++){
                sum= i==0 ? pref[j] : pref[j]-pref[i-1];
            }
            if(max<sum){
                max=sum;
            }
        }
        System.out.println("Maximum sum is: "+max);
    }
    public static void main(String[] args) {
        int arr[]={1,-2,-3,4,5};
        prefix(arr);
    }
}
//time complexiety is O(n^2) it is optimize solution than normal method