package dsa_java.Bit_manipulation;

public class updateithBit {
    public static int clearBit(int num, int pos){
        int bitMask= ~(1<<pos);
        return num & bitMask;
    }
    public static int setIthBit(int num, int i){

        return num|(1<<i);
    }
    public static int updateBit(int num, int i,int newbit){
        // if(newbit==0){
        //    return clearBit(num,i);
        // }
        // if(newbit==1){
        //    return setIthBit(num,i);
        // }
        // return -1;

        //second approach

        num=clearBit(num, i);
        int bitMask=newbit<<i;

        return num | bitMask;
    }
    public static void main(String[] args) {
       System.out.println(updateBit(10, 1, 0)); 
    }
}