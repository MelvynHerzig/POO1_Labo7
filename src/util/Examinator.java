package util;

public class Examinator
{
    private Element elem;

    Examinator(Element elem)
    {
        this.elem = elem;
    }

    public Object next()
    {
        elem = elem.next;
        return elem.value;
    }

    public boolean hasNext()
    {
        return elem.next != null;
    }
}
