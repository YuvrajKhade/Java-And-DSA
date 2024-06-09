package dsa_java.Strings;

public class largestString {

    public static void lexicographically(String str[]){
        String large=str[0];
        for(int i=1;i<str.length;i++ ){

            if(large.compareTo(str[i])<0){
                large=str[i];
            }
        }
        System.out.println("Lagest String lexicographically: "+large);
    }
    public static void main(String[] args) {
        String fruit[]={"apple", "banana", "mango","kivi"};
        lexicographically(fruit);
    }
}
