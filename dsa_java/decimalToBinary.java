package dsa_java;

public class decimalToBinary {
    public static void convert(int num){
        int pow=0;
        int binary=0;
        int temp=num;
        while(num>0){
            int ld=num%2;
            binary=binary+(ld*(int)Math.pow(10, pow));
            
            pow++;
            num=num/2;
        }
        System.out.println("Binary equivalent is "+temp+" "+binary);
    }
    public static void main(String[] args) {
        convert(164);
    }
}
