package app;

public class LSEO<T extends Comparable<T>> implements IListaOrdenada<T> {
    private Node head;
    private int size;
    private boolean ascending;

    public LSEO(boolean ascending) {
        head = null;
        size = 0;
        this.ascending = ascending;
    }

    public LSEO() {
        this(true);
    }

    class Node {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    @Override
    public void insert(T value) {
        Node newNode = new Node(value);
        Node current = head;
        Node previous = null;
        if (this.ascending == true) {
            while (current != null && value.compareTo(current.value) > 0) {
                previous = current;
                current = current.next;
            }
        } else {
            while (current != null && value.compareTo(current.value) < 0) {
                previous = current;
                current = current.next;
            }
        }
        if (previous == null) {
            head = newNode;
        } else {
            previous.next = newNode;
        }
        newNode.next = current;
        this.size++;
    }

    @Override
    public Node remove(T e) {
        if (head == null) {
            throw new RuntimeException("List is empty..");
        }

        Node previousNode = null;
        Node currentNode = this.head;
        for (int i = 0; i < this.size; i++) {
            if (currentNode.value.compareTo(e) == 0) {
                previousNode.next = currentNode.next;
                this.size--;
                return currentNode;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        throw new RuntimeException(e + " is not in the list");
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        buffer.append("[");

        if (head != null) {
            Node aux = head;
            while (aux.next != null) {
                buffer.append(aux.value);
                buffer.append(", ");
                aux = aux.next;
            }

            buffer.append(aux.value);
        }

        buffer.append("]");

        return buffer.toString();
    }

    @Override
    public int length() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}