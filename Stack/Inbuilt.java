package Stack;
import java.util.*;
//https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/lectures/19-stacks-n-queues/code/src/com/kunal/InBuiltExamples.java
public class Inbuilt {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(18);
        System.out.println("Elements in stack using pop");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
       // System.out.println(stack.pop());


    }

}
//time Complexity O(1)
