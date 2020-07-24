package structures;

public class RecursiveList<T> implements ListInterface<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public RecursiveList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public RecursiveList<T> insertFirst(T elem) {
        Node<T> newElem = new Node<T>(elem, null);
        if (this.isEmpty()) {
            head = newElem;
            tail = newElem;
            return this;
        } else {
            newElem.setNext(head);
            head = newElem;
            return this;
        }
    }

    @Override
    public RecursiveList<T> insertLast(T elem) {

        return this;
    }

    @Override
    public ListInterface<T> insertAt(int index, T elem) {

        return this;
    }

    @Override
    public T removeFirst() {

        return T;
    }

    @Override
    public T removeLast() {

        return T;
    }

    @Override
    public T removeAt(int i) {

        return T;
    }

    @Override
    public T getFirst() {
        if (this.isEmpty())
            throw new IllegalStateException();
        else
            return head.getData();
    }

    @Override
    public T getLast() throws IllegalStateException {
        if (this.isEmpty())
            throw new IllegalStateException();
        else
            return tail.getData();
    }

    @Override
    public T get(int i) {

        return T;
    }

    @Override
    public boolean remove(T elem) {

        return false;
    }

    public int indexOf(T elem) {

        return -1;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

}