package dsa_java.recursion;

public class printIncreasingNum {

    public static void print(int num){
        if (num ==1) {
            System.out.print(" "+num);
            return;
        }
        print(num-1);
        System.out.print(" "+num);
    }
    public static void main(String[] args) {
        print(10);
    }
}
