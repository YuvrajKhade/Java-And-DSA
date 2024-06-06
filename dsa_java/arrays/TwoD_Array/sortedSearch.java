public class sortedSearch {

    public static boolean sort(int arr[][],int key){

        // int row=0, col=arr[0].length-1;

        // while (row<=arr.length-1 && col>=0) {
        //     if(key==arr[row][col]){
        //         System.out.println("Key is present at ("+row+" , "+col+")");
        //         return true;
        //     }
        //     else if(key > arr[row][col]){
        //         row++;
        //     }
        //     else{
        //         col--;
        //     }
        // }

        //when we start from bottom left corner
        int row=arr.length-1, col=0;

        while (col<=arr[0].length-1 && row>=0) {
            if(key==arr[row][col]){
                System.out.println("Key is present at ("+row+" , "+col+")");
                return true;
            }
            else if (key > arr[row][col]) {
                col++;
            }
            else{
                row--;
            }
        }
        System.out.println("Key not found");
        return false;
    }
    public static void main(String[] args) {
        int arr[][]={{10,15,20,25},
                    {30,35,40,45},
                    {50,55,60,65},
                    {70,75,80,85}};
        int key=80;

        sort(arr, key);
    }
}
