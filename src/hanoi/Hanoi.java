package hanoi;

import util.Stack;

/**
 * Classe permettant la résolution du problème des tours d'hanoi.Hanoi.
 *
 * @author Forestier Quentin, Herzig Melvyn
 * @version 18.11.2020
 */

public class Hanoi
{
    private final int maxTurn;
    private final int diskNumber;
    private int turnCounter;

    private final Stack s1;
    private final Stack s2;
    private final Stack s3;


    private final HanoiDisplayer displayer;

    /**
     * Constructeur générique de la classe
     *
     * @param disks     Nombre de disques
     * @param displayer Objet permettant l'affichage des aiguilles d'hanoi.Hanoi
     */
    public Hanoi(int disks, HanoiDisplayer displayer)

    {
        this.turnCounter = 0;
        this.diskNumber = disks;

        this.displayer = displayer;

        maxTurn = (int) (Math.pow(2, diskNumber) - 1);

        s1 = new Stack();
        s2 = new Stack();
        s3 = new Stack();

        for (int i = diskNumber; i > 0; i--)
        {
            s1.push(i);
        }

    }

    /**
     * Constructeur avec displayer par défaut
     *
     * @param disks
     */
    public Hanoi(int disks)
    {
        this(disks, new HanoiDisplayer());
    }


    /**
     * Déplace les disques de la première à la troisième aiguille.
     * Affiche toutes les étapes grâce à un HanoiDisplayer.
     */
    public void solve()
    {

        Stack inter = diskNumber % 2 == 0 ? s3 : s2;
        Stack dest = diskNumber % 2 == 0 ? s2 : s3;


        displayer.display(this);

        while (!finished())
        {
            turnCounter++;
            switch (turnCounter % 3)
            {
                case 0:
                    transfer(inter, dest);
                    break;
                case 1:
                    transfer(s1, dest);
                    break;
                case 2:
                    transfer(s1, inter);
                    break;
            }
            displayer.display(this);
        }

    }

    /**
     * Rend un tableau de tableaux représentant l'état des 3 aiguilles.
     *
     * @return Tableau de tableaux de int contenant l'état des
     * aiguilles.
     */
    public int[][] status()
    {
        int[][] t = new int[3][];

        Stack[] tbl = new Stack[]{s1, s2, s3};

        for (int i = 0; i < tbl.length; i++)
        {
            t[i] = new int[tbl[i].size()];
            Object[] tmp = tbl[i].toArray();

            for (int j = 0; j < tbl[i].size(); j++)
            {
                t[i][j] = (int) tmp[j];
            }
        }


        return t;
    }

    /**
     * Permet de savoir si tous les disques sont sur la troisième
     * aiguille.
     *
     * @return True si la solution est atteinte, False sinon
     */
    public boolean finished()
    {
        return s1.isEmpty() && s2.isEmpty() && maxTurn == turnCounter;
    }

    /**
     * Nombre de fois qu'un disque a été déplacé.
     *
     * @return Compteur du nombre d'itération.
     */
    public int turn()
    {
        return turnCounter;
    }

    /**
     * Convertit l'objet hanoi.Hanoi en chaine de caractère
     *
     * @return Hanoi convertit en chaine de caractère
     */
    @Override
    public String toString()
    {
        return String.format("" +
                "-- Turn : %d\n" +
                "One  : %s\n" +
                "Two  : %s\n" +
                "Three: %s", turnCounter, s1, s2, s3);
    }

    /**
     * Transfert l'élément le plus petit entre les 2 sommets des piles sur la
     * bonne pile
     *
     * @param src
     * @param dest
     */
    private void transfer(Stack src, Stack dest)
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
