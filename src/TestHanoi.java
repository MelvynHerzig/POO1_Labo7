import hanoi.Hanoi;
import hanoi.gui.JHanoi;


/**
 * Classe de test pour vérifier le bon fonctionnement de hanoi.Hanoi
 *
 * @author Forestier Quentin, Herzig Melvyn
 * @version 18.11.2020
 */
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
