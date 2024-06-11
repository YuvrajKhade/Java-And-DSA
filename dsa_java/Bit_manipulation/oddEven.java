package dsa_java.Bit_manipulation;

public class oddEven {

    public static void oddOrEven(int no){

        int bitmask=1;
        if((no & bitmask)==0){
            System.out.println("No. is EVEN");
        }
        else{
            System.out.println("No. is ODD");
        }
    }
    public static void main(String[] args) {
        oddOrEven(4);
        oddOrEven(7);

    }
}
