package dsa_java.Bit_manipulation;

public class powerOfTwo {

    public static boolean power(int num){
        return (num & (num-1))==0;
    }
    public static void main(String[] args) {
        System.out.println("Status of power of two: "+power(8));
    }
}
