package dsa_java.Bit_manipulation;

public class clearLastBit {

    public static int clear(int num , int i){
        int bitMask=(-1)<<i;
        return num & bitMask;
    }
    public static void main(String[] args) {
        System.out.println("New no is: "+clear(15, 2));
    }
}
