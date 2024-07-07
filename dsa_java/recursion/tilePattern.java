package dsa_java.recursion;

public class tilePattern {
    public static int tile(int n){ //surface=2 X n
        if(n==0 || n==1){
            return 1;
        }
        int fnm1=tile(n-1);//vertical becoz tile= 2 X 1

        int fnm2=tile(n-2);

        return fnm1 + fnm2;
    }
    public static void main(String[] args) {
        System.out.println("No. of ways: "+tile(4));
    }
}
