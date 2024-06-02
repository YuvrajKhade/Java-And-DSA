// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
import java.time.*;
import java.util.*;
class Player
{
    Scanner sc=new Scanner(System.in);
    
    LocalDate ld=LocalDate.now();
    Date d = new Date();  
      
    int runs,jno;
    String name,date;
    int age,wic;
    String status;
    
    void get()
    {
        System.out.println("Enter player's name ");
        name=sc.next();
        System.out.println("Enter player's DOB(): ");
        date=sc.next();
        System.out.println("Enter player's runs : ");
        runs=sc.nextInt();
        System.out.println("Enter player's Jersy no.: ");
        jno=sc.nextInt();
        System.out.println("Enter total no of wickets: ");
        wic=sc.nextInt();
        
        
        
    }
    
    
    void cal_age()
    {
        LocalDate fordate=LocalDate.parse(date);
       // age=ld - fordate;
        System.out.println("Your age is: "+age);
    }
    void set()
    {
        System.out.println("Name: "+name);
        System.out.println("DOB: "+age);
        System.out.println("Runs: "+runs);
        System.out.println("Jersy no.: "+jno);
        System.out.println("Wickets: "+wic);
    }
    
    
}
class HelloWorld {
    public static void main(String[] args)
    {
        Player p=new Player();
	    p.get();
	    p.cal_age();
    }
}