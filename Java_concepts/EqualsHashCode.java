package Java_concepts;

public class EqualsHashCode {
    public static void main(String[] args) {
        String s1="hello";
        String a2="hello";
        System.out.println(s1==a2);//true
        System.out.println(s1.equals(a2));//true
        String s11=new String("hello");
        String a21=new String("hello");
        System.out.println(s11==a21); //false..checks for reference
        System.out.println(s11.equals(a21)); //true.. equals check for value
    }

}
