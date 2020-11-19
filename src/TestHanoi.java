public class TestHanoi
{
    public static void main(String[] args)
    {
        Hanoi hanoi = new Hanoi(Integer.parseInt(args[0]));


        System.out.println(hanoi);

        while(!hanoi.isFinish())
        {
            hanoi.nextIteration();
            System.out.println(hanoi);
        }
    }
}
