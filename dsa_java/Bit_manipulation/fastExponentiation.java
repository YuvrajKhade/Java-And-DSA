package dsa_java.Bit_manipulation;
public class fastExponentiation {

    public static int power(int base,int pow){
        int ans=1;

        while (pow > 0) {

            ans= base * ans;
        }

        base=base * base;
        pow=pow>>1;

        return ans;
    }
    public static void main(String[] args) {

        System.out.println("Power is: "+power(3, 5));
    }
}
