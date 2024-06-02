import java.util.Scanner;
abstract class Shape
{
    public float rarea,tarea,carea;
    abstract void cal_area();
    public void display()
    {
        System.out.println("Area of Rectangle: "+rarea);
        System.out.println("Area of Traingle: "+tarea);
        System.out.println("Area of Circle: "+carea);
    }
}
class Rectangle extends Shape
{
    int len,bred;
    void get()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length: ");
        len=sc.nextInt();
        System.out.println("Enter Breadth ");
        bred=sc.nextInt();
        sc.close();
    }
    void cal_area()
    {
        rarea=len*bred;
    }
}
class Triangle extends Shape
{
    float high,base;
    void get()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Base: ");
        base=sc.nextInt();
        System.out.println("Enter Height: ");
        high=sc.nextInt();
        sc.close();
    }
    void cal_area()
    {
        tarea=(1/2)*high*base;
    }
}
class Circle extends Shape
{
    float rad;
    void get()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Radius: ");
        rad=sc.nextInt();
        sc.close();
        
    }
    void cal_area()
    {
        carea=(22/7)*rad*rad;
    }
}
class Show
{
    public static void main(String args[])
    {
        Rectangle r=new Rectangle();
        r.get();
        r.cal_area();
        Triangle t =new Triangle();
        t.get();
        t.cal_area();
        Circle c =new Circle();
        c.get();
        c.cal_area();
       
        r.display();
        t.display();
        c.display();
        
    }
}