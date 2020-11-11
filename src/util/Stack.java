package util;

public class Stack
{
    private int size;
    private Element head;

    public Stack()
    {
        head = null;
        size = 0;
    }

    public Object top()
    {
        if(isEmpty()) throw new RuntimeException();

        return head.value;
    }

    public void pop()
    {
        if(isEmpty()) throw new RuntimeException();

        head = head.next;
        size--;
    }

    public void push(Object o)
    {
        head = new Element(o, head);
        size++;
    }

    @Override
    public String toString()
    {
        StringBuilder data = new StringBuilder();

        for (Object o: toArray())
        {
            data.append(String.format("<%s> ", o));
        }

        return String.format("[ %s]", data.toString());
    }

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

    public Examinator examinator()
    {
        return new Examinator(head);
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }
}
