package dsa_java.arrays.TwoD_Array;

public class spiralMatrix {

    public static void sprial(int arr[][]){

        int startRow=0;
        int startCol=0;
        int endRow=arr.length-1;
        int endCol=arr[0].length-1;

        while (startRow<=endRow && startCol<=endCol) {
            //top
            for(int col=startCol;col<=endCol;col++){
                System.out.print(" "+arr[startRow][col]);
            }

            //rigth
            for(int row=startRow+1;row<=endRow;row++){
                System.out.print(" "+arr[row][endCol]);
            }

            //bottom
            for(int col=endCol-1;col>=startCol;col--){
                if (startCol==endCol) {
                    break;
                }
                System.out.print(" "+arr[endRow][col]);
            }

            //left
            for(int row=endRow-1;row>=startRow+1;row--){
                if (startRow==endRow) {
                    break;
                }
                System.out.print(" "+arr[row][startCol]);
            }
            
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        System.out.println();
        
    }
    public static void main(String[] args) {
        int arr[][]={{1,2,3},
                    {5,6,7},
                    {9,10,11},
                    {13,14,15}};
        sprial(arr);
    }
}
