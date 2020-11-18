import hanoi.Hanoi;
import hanoi.gui.JHanoi;

public class TestHanoi
{
    public static void main(String[] args)
    {
        int disksNumber = Integer.parseInt(args[0]);

        switch(args[1])
        {
            case "graphique":
                new JHanoi();
                break;
            case "console":
                new Hanoi(disksNumber).solve();
                break;
        }

    }
}
