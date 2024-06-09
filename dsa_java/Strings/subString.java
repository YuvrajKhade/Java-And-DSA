package dsa_java.Strings;

public class subString {

    public static void subS(String str , int si, int ei){
        String substr="";
        for (int i = si; i < ei; i++) {
            substr+=str.charAt(i);
        }
        System.out.println("Substring is: "+substr);
    }
    public static void main(String[] args) {
        String str="hello yuvi";
        subS(str, 0, 9);
    }
}
