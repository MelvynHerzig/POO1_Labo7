package util;

/**
 * Classe implémentant le fonctionnement d'une pile LIFO.
 *
 * @author Forestier Quentin, Herzig Melvyn
 * @version 11.11.2020
 */
public class Stack
{
    private int size;
    private Element head;

    /**
     * Constructeur de pile.
     */
    public Stack()
    {
        head = null;
        size = 0;
    }

    /**
     * Fonction de récupération du haut de la pile.
     * @return Retourne le sommet de la pile.
     * @throws RuntimeException si liste vide
     */
    public Object top()
    {
        if(isEmpty()) throw new RuntimeException("top on empty stack");

        return head.value;
    }

    /**
     * Supprime l'élément en haut de la pile.
     * @throws RuntimeException si liste vide
     */
    public void pop()
    {
        if(isEmpty()) throw new RuntimeException("pop on empty stack");

        head = head.next;
        size--;
    }

    /**
     * Ajoute un élément en haut de la pile.
     * @param o Élément à ajouter en haut de la pile.
     */
    public void push(Object o)
    {
        head = new Element(o, head);
        size++;
    }

    /**
     * Convertit la pile en chaîne de caractères.
     * @return Pile convertie en chaîne de caractères.
     */
    public String toString()
    {
        StringBuilder data = new StringBuilder();

        for (Object o: toArray())
        {
            data.append(String.format("<%s> ", o));
        }

        return String.format("[ %s]", data.toString());
    }

    /**
     * Converti les éléments de la pile en un tableau.
     * @return Tableau contenant les éléments de la pile. 0 = haut de la pile.
     */
    public Object[] toArray()
    {
        if(isEmpty()) return new Object[0];

        Object[] tbl = new Object[size];
        Element current = head;


        for(int i = 0; i < tbl.length; ++i)
        {
            tbl[i] = current.value;
            current = current.next;
        }

        return tbl;
    }

    /**
     * Crée et retourne un examinateur sur le début de la pile.
     * @return Examinateur sur le début de la pile, regarde null si pile vide.
     */
    public Examinator examinator()
    {
        return new Examinator(new Element(null, head));
    }

    /**
     * Vérifie si la pile est vide.
     * @return Vrai si la pile est vide.
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /*
     * @return Renvoie la taille de la pile
     */
    public int size()
    {
        return size;
    }
}
