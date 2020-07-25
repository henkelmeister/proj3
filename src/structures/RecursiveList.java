package structures;

import java.util.Iterator;

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
    public RecursiveList<T> insertFirst(T elem) throws NullPointerException {
        if(elem == null)throw new NullPointerException();
        Node<T> newElem = new Node<T>(elem, null);
        if (this.isEmpty()) {
            head = newElem;
            tail = newElem;
            size++;
            return this;
        } else {
            newElem.setNext(head);
            head = newElem;
            size++;
            return this;
        }
    }

    @Override
    public RecursiveList<T> insertLast(T elem) throws NullPointerException {
        if(elem == null)throw new NullPointerException();
        Node<T> newElem = new Node<T>(elem,null);
        if(this.isEmpty()){
            head = newElem;
            tail = newElem;
            size++;
            return this;
        } else{
            tail.setNext(newElem);
            tail = newElem; 
            size++;
            return this; 
            
        }
    }

    @Override
    public ListInterface<T> insertAt(int index, T elem) {

        return this;
    }

    @Override
    public T removeFirst() throws IllegalStateException {
        if(isEmpty()) throw new IllegalStateException();
        Node<T> tempNode = head;
        head = head.getNext();
        tempNode.setNext(null); 
        return tempNode.getData();
    }

    @Override
    public T removeLast() throws IllegalStateException {
        if(isEmpty())throw new IllegalStateException(); 
        Node<T> last = head.getNext();
        Node<T> seccondLast = head; 
        return removeLastHelper(seccondLast, last);
    }

    private T removeLastHelper(Node<T> seccondLast, Node<T> last){

        if(last.getNext()==null){
            seccondLast.setNext(null);
            tail = seccondLast; 
            return seccondLast.getData();
        }

        return removeLastHelper(seccondLast.getNext(),last.getNext());
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
    public T get(int i) throws IndexOutOfBoundsException {
        if(i < 0 || i >= size) throw new IndexOutOfBoundsException();

        return getHelper(i,head);
    }

    private T getHelper(int j,Node<T> newHead){

        if(j == 0){
            return newHead.getData(); 
        }

        return getHelper(j-1,newHead.getNext());

    }

    @Override
    public boolean remove(T elem) throws NullPointerException {
        if(elem == null)throw new NullPointerException();
       
        return removeHelper(elem,head,null);
    }

    private boolean removeHelper(T elem,Node<T> currNode,Node<T> prevNode){
        if(currNode == null)return false; 

        if(elem.equals(currNode.getData())){
            if(prevNode == null){
                removeFirst();
                return true; 
            } 
            prevNode.setNext(currNode.getNext());
        return true; 
        }
        return removeHelper(elem,currNode.getNext(),currNode);
    }

    public int indexOf(T elem) {

        return -1;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator(){
        return null;
    }

}