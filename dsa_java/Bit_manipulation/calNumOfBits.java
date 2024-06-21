package dsa_java.Bit_manipulation;

public class calNumOfBits {

    public static int calculate(int num){
        int count=0;

        while (num >0) {
            if((num & 1)==1){
                count++;
            }
            num= num >> 1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println("No of bits: "+calculate(15));
    }
}
