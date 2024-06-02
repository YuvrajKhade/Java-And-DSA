package dsa_java.arrays.TwoD_Array;

import java.util.Scanner;

public class search {

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

    public static void search1(int arr[][],int key){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i][j]==key){
                    System.out.println("Element found at ("+i+" "+j+")");
                }
            }
        }
        
    }
    public static void main(String[] args) {
        int arr[][]=new int[3][3];
        input(arr);
        print(arr);
        int key=5;
        search1(arr,key);
    }
}
