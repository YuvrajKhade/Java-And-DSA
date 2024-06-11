package dsa_java.Bit_manipulation;

public class setithBit {

    public static int setIthBit(int num, int i){

        return num|(1<<i);
    }
    public static void main(String[] args) {
        System.out.println("Number is: "+setIthBit(10, 2));
    }
}
