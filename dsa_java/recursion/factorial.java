//package dsa_java.recursion;

public class factorial {

    public static int fact(int num){
        int result=1;
        if(num<0){
            return -1;
        }
        if(num==0){
            return 1;
        }
        result= num * fact(num-1);
        return result;
        
    }
    public static void main(String[] args) {
        System.out.println("factorial is: "+fact(-4));
    }
}
