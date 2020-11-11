import util.Stack;

public class Test
{
    public static void main(String[] args)
    {
        Stack s = new Stack();


        s.push("1");
        s.push("2");

        s.pop();


        s.push(new Stack());
        s.push("3");
        s.push('a');
        s.push("5");
        s.push(3);


        System.out.println(s);
    }
}
