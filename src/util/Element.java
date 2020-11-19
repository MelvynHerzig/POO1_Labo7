package util;

/**
 * Classe des éléments de Stack.
 *
 * @author Forestier Quentin, Herzig Melvyn
 * @version 11.11.2020
 */
class Element
{
    Object value;
    Element next;

    /**
     * Constructeur
     * @param o Objet contenu.
     * @param next Référence vers l'élément suivant.
     */
    Element(Object o, Element next)
    {
        this.value = o;
        this.next = next == this ? null : next;
    }

    /**
     * Constructeur, Initialise la référence à l'Element suivant à null.
     * @param o Objet contenu.
     */
    Element(Object o)
    {
        this(o, null);
    }

}
