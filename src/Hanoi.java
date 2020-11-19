import util.Stack;

public class Hanoi
{
    private int maxTurn;
    private int turnCounter;
    private int diskNumber;

    private Stack s1;
    private Stack s2;
    private Stack s3;

    public Hanoi(int aDiskNumber)
    {
        this.turnCounter = 0;
        this.diskNumber = aDiskNumber;

        maxTurn = (int) (Math.pow(2, diskNumber) - 1);

        s1 = new Stack();
        s2 = new Stack();
        s3 = new Stack();

        for (int i = diskNumber; i > 0; i--)
        {
            s1.push(i);
        }
    }

    public void nextIteration()
    {

        turnCounter++;
        switch (turnCounter % 3)
        {
            case 0:
                transfert(s3, s2);
                break;
            case 1:
                transfert(s1, s2);
                break;
            case 2:
                transfert(s1, s3);
                break;
        }

    }

    public boolean isFinish()
    {
        return maxTurn == turnCounter;
    }

    @Override
    public String toString()
    {
        return String.format("" +
                "-- Turn : %d\n" +
                "One  : %s\n" +
                "Two  : %s\n" +
                "Three: %s", turnCounter, s1, s2, s3);
    }

    private void transfert(Stack src, Stack dest)
    {

        if (src.isEmpty())
        {
            src.push(dest.top());
            dest.pop();
        }
        else if (dest.isEmpty())
        {
            dest.push(src.top());
            src.pop();
        }
        else if ((int) src.top() > (int) dest.top())
        {
            src.push(dest.top());
            dest.pop();
        }
        else
        {
            dest.push(src.top());
            src.pop();
        }
    }
}
