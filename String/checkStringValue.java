package String;

public class checkStringValue {
    String s="hello";
    public static void main(String[] args) {
     String s=null;
       System.out.println("local variable:"+s);
        checkStringValue vc=new checkStringValue();
        System.out.println("before value change from getter:"+vc.getMyString());
        vc.setMystring("value changed");
        s= vc.getMyString();
        System.out.println("after calling setter:"+s);
    }

    public String getMyString()
    {
        return s;
    }
    public void setMystring(String s1)
    {
        s=s1;
    }

}
