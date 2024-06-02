package dsa_java.arrays;

public class linearSearch {
    public static int search(String menu[],String key){
        int i;
        for(i=0;i<menu.length;i++){
            if(menu[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String menu[]={"dosa","idli","samosa","choale bhature","uttapa"};
        String key="samosa";
        
        if (search(menu,key)==-1) {
            System.out.println("Not found");
        } else {
            System.out.println("Key found at position: "+(search(menu,key)+1));
        }
    }
}
