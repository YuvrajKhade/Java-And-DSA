package dsa_java.arrays;

public class buySellStocks {

    public static int stock(int price[]){

        int buyprice=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int i=0;i<price.length;i++){
            if(buyprice<price[i]){
                int profit=price[i]-buyprice;
                maxprofit=Math.max(maxprofit, profit);
            }
            else{
                buyprice=price[i];
            }
        }
        return maxprofit;
    }
    public static void main(String[] args) {
        int price[]={10,11,3,6,8,9};
        System.out.println("Maximum profit is: "+stock(price));
    }
}
