
public class diagonalSum {

    public static int diagonal(int arr[][]){

        int sum=0;
        //not optimized code O(n^2)
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<arr[0].length;j++){
        //         if(i==j){
        //             sum+=arr[i][j];
        //         }
        //         if(i+j==arr.length-1){
        //             sum+=arr[i][j];
        //         }
        //     }
        // }

        //this is optimized code O(n)
        for(int i=0;i<arr.length;i++){
            sum+=arr[i][i];

            sum+=arr[i][arr.length-i-1];
        }
        return sum;
    }
    public static void main(String[] args) {
        int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Sum of diagonal is: "+diagonal(arr));
    }
}
