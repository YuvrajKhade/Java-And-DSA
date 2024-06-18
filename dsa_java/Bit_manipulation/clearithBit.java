package dsa_java.Bit_manipulation;

public class clearithBit {

    public static int clearBit(int num, int pos){
        int bitMask= ~(1<<pos);
        return num & bitMask;
    }
    public static void main(String[] args) {
        System.out.println("New num is: "+(clearBit(10, 1)));
    }
}
