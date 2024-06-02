package dsa_java;
class binomialcoeff{
    public static int fact(int n){
        int res=1;
        for(int i=1;i<=n;i++){
            res*=i;
        }
        return res;
    }
    public static int bio(int n,int r){
        int nfact=fact(n);
        int rfact=fact(r);
        int nmrfact=fact(n-r);
        int resbio=nfact/(rfact*nmrfact);
        return resbio;
    }

    public static void main(String args[])
    {
        System.out.println(bio(5,2));
    }
}