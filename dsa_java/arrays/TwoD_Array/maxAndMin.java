package dsa_java.arrays.TwoD_Array;

import java.util.Scanner;

public class maxAndMin {
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
     public static void maxAndmin(int arr[][]){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(max<arr[i][j]){
                    max=arr[i][j];
                }
                if(min>arr[i][j]){
                    min=arr[i][j];
                }
            }
        }
        System.out.println("Maximum no is: "+max);
        System.out.println("Minimum no is: "+min);
     }

    public static void main(String[] args) {
        int arr[][]=new int[3][3];
        input(arr);
        print(arr);
        maxAndmin(arr);
    }
}
