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
        switch(args[0])
        {
            case "graphique":
                new JHanoi();
                break;
            case "console":
                int disksNumber = Integer.parseInt(args[1]);
                new Hanoi(disksNumber).solve();
                break;
        }

    }
}
