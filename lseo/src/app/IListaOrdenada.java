package app;

import app.LSEO.Node;

public interface IListaOrdenada<T> {

    public void insert(T e);

    public Node remove(T e);

    public int length();

    public boolean isEmpty();

    public String toString();

}
