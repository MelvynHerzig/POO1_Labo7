import hanoi.Hanoi;
import hanoi.gui.JHanoi;

/**
 * Classe de test pour vérifier le bon fonctionnement de Hanoi
 *
 * @author Forestier Quentin, Herzig Melvyn
 * @version 18.11.2020
 */
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
