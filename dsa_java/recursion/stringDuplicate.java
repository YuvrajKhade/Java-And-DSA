package dsa_java.recursion;

public class stringDuplicate {

    public static void removeDuplicates(int idx, String str,StringBuilder sb,boolean[] status){

        if(idx==str.length()){
            System.out.println("String after removing duplicates: "+sb);
            return;
        }

        char cur=str.charAt(idx);
        if(status[cur-'a']==true){
            removeDuplicates(idx+1, str, sb, status);
        }
        else{
            status[cur-'a']=true;
            removeDuplicates(idx+1, str, sb.append(cur), status);
        }

    }

    public static void main(String[] args) {
        
        removeDuplicates(0, "appannacollege", new StringBuilder(), new boolean[26]);
    }
}
