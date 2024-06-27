public class fibonacci {

    public static int fibo(int num){
        if(num==0){
            return 0;
        }
        if(num==1){
            return 1;
        }
        int fib_res=fibo(num-1) + fibo(num-2);

        return fib_res;
    }
    public static void main(String[] args) {
        System.out.println("Fibonacci series: "+fibo(5));
    }
}
