package util;

class Element
{
    Object value;
    Element next;

    Element(Object o, Element next)
    {
        this.value = o;
        this.next = next;
    }

    Element(Object o)
    {
        this(o, null);
    }

}
