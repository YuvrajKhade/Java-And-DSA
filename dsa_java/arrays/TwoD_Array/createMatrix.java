package dsa_java.arrays.TwoD_Array;

import java.util.Scanner;

public class createMatrix {
    
    public static void input(int arr[][]){
        Scanner sc=new Scanner(System.in);

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        sc.close();
    }
    public static void print(int arr[][]){
        

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(" "+ arr[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[][]=new int[3][3];
        input(arr);
        print(arr);

    }
}
