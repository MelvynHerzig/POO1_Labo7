package util;

/**
 * Classe implémentant l'équivalent des itérateur sur la classe Stack
 *
 * @author Forestier Quentin, Herzig Melvyn
 * @version 11.11.2020
 */
public class Examinator
{
    private Element elem;

    /**
     * Constructeur.
     * @param elem Element sur lequel pointer.
     */
    Examinator(Element elem)
    {
        this.elem = elem;
    }

    /**
     * Avance l'itérateur est retourne le contenu de l'Element observé.
     * @return Contenu du nouvel Element.
     */
    public Object next()
    {
        elem = elem.next;
        return elem.value;
    }

    /**
     * Vérifie si l'Element pointé par l'itérateur est le dernier.
     * @return Faux si des Element suivent.
     */
    public boolean hasNext()
    {
        return elem.next != null;
    }
}
