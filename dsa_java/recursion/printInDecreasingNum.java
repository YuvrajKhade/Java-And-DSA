package dsa_java.recursion;

public class printInDecreasingNum {

    public static void print(int num){
        if(num == 1){
            System.out.print(" "+num);
            return;
        }
        System.out.print(" "+num);
        print(num-1);
    }
    public static void main(String[] args) {
        print(10);
    }
}
