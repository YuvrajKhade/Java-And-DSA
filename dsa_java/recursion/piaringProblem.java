package dsa_java.recursion;
public class piaringProblem {

    public static int pair(int n){
        if(n==1 || n==2){
            return n;
        }

        int fnm1= pair(n-1);
        int fnm2=pair(n-2);
        int pairTotal=(n-1)*fnm2;

        return fnm1 + pairTotal;
    }
    public static void main(String[] args) {
        System.out.println(pair(5));
    }
}

