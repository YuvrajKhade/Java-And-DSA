public class sumOfNNumber {

    public static int sum(int num){
        if(num==1){
            return 1;
        }
        int res=0;
        res=num+sum(num-1);
        return res;
    }
    public static void main(String[] args) {
        System.out.println("N number of sum: "+sum(5));
    }
}
