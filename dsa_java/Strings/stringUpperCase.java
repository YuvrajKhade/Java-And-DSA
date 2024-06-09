package dsa_java.Strings;

public class stringUpperCase {

    public static String toupper(String str){

        StringBuilder sb=new StringBuilder();

        char str2=Character.toUpperCase(str.charAt(0));
        sb.append(str2);

        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' ' && i<str.length()-1){

                sb.append(str.charAt(i));
                i++;

                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String str="hello, i am yuvraj khade";
        System.out.println(toupper(str));
    }
}
//time complexity is O(n)