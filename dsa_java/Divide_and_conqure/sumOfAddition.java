package dsa_java.Divide_and_conqure;

public class sumOfAddition {

    public static String Sum(String str1,String str2){

        int len1=str1.length();
        int len2=str2.length();

        if(len1<len2){
            String temp=str1;
            str1=str2;
            str1=temp;
        }
        String chr=" ";
        int carry=0;

        str1=new StringBuilder(str1).reverse().toString();
        str2=new StringBuilder(str2).reverse().toString();

        for(int i=0;i<len2;i++){
            int sum1=(int)str1.charAt(i)-'0';
            int sum2=(int)str2.charAt(i)-'0';
            
            

            int result=sum1+sum2+carry;

            chr += (char)(result%10+'0');
            carry=result/10;
        }

        for(int i=len2;i<len1;i++){
            
            int result=(int)(str1.charAt(i)-'0')+carry;
            chr+=(char)(result%10+'0');
            carry=result/10;
        }
        if(carry>0){
            chr+=(char)(carry+'0');
        }
        chr=new StringBuilder(chr).reverse().toString();

        return chr;
       
    }

    public static void main(String[] args) {
        String str1="123456";
        String str2="123";
        System.out.println(Sum(str1, str2));
    }
}
