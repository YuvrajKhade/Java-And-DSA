
public class prime {
    // static void isprime(int n){
    //     for(int i=2;i<n;i++){
    //         if (n%i==0) {
    //             System.out.println("Number is not prime");
    //             break;
    //         }
    //         else{
    //             System.out.println("Number is prime");
    //         }
    //     }
        
    // }
    static void isprime(int n){
            for(int i=2;i<=Math.sqrt(n);i++){
                if (n%i==0) {
                    System.out.println("Number is not prime");
                    break;
                }
                else{
                    System.out.println("Number is prime");
                }
            }
            
        }


    public static void main(String[] args) {
       //isprime(12);
       isprime(47);
       
    }
    
}
