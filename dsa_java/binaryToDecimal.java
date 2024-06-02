package dsa_java;

public class binaryToDecimal {
    public static void convert(int num){
        int pow=0;
        int decimal=0;
        int temp=num;

        while(num>0){
            int ld=num%10;
            decimal=decimal+(ld*(int)Math.pow(2, pow));
            pow++;
            num=num/10;
        }
        System.out.println("Decimal num of "+temp+" is "+decimal);
    }
    public static void main(String[] args) {
        convert(101010);
    }
}
