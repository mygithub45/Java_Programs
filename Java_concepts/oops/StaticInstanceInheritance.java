

public class StaticInstanceInheritance {
    public static void printcolor()
    {
        System.out.println("parent");
    }

    public  void checkcolor()
    {
        System.out.println("parent checkcolor");
    }
}
class sub extends StaticInstanceInheritance{
    public static void printcolor()
    {
        System.out.println("child");
    }

    public  void checkcolor()
    {
        System.out.println("child checkcolor");
    }
    public static void main(String[] s)
    {
        StaticInstanceInheritance m1=new sub();
        StaticInstanceInheritance m2=new StaticInstanceInheritance();
        sub m3=new sub();

        sub s1=new sub();
        StaticInstanceInheritance s2=new sub();
        sub s3=new sub();
        StaticInstanceInheritance s4=new sub();
        StaticInstanceInheritance s5=new StaticInstanceInheritance();

        s1.printcolor();//child
        s2.printcolor();//parent
        s3.printcolor();//child
        m1.checkcolor(); //child
        m2.checkcolor();//parent
        m3.checkcolor();//child
        s4.printcolor();//parent
       s4.checkcolor();//child checkcolor
    }
}
