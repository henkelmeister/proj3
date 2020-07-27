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
        if(elem == null){
            throw new NullPointerException();
        }
        Node<T> newElem = new Node<T>(elem, head);
        head = newElem; 
        size++;
        if(size == 1){
            this.tail = this.head; 
        }

        return this; 
    }

    @Override
    public RecursiveList<T> insertLast(T elem) throws NullPointerException {
        if(elem == null){
            throw new NullPointerException();
        }
        
        if(this.isEmpty()){
            return insertFirst(elem);
        }

        Node<T> newElem = new Node<T>(elem,null);
        
            tail.setNext(newElem);
            tail = newElem; 
            size++;
            return this;     
    }

    @Override
    public ListInterface<T> insertAt(int index, T elem)throws NullPointerException, IndexOutOfBoundsException {
        if(elem == null){
            throw new NullPointerException();
        }
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException(); 
        }
        if(index == 0){
            return this.insertFirst(elem);  
        }

        if(index == size){
            return insertLast(elem);
        }
        Node<T> priorNode = getHelper(index - 1,head); 
        Node<T> insertNode = new Node<T>(elem,priorNode.getNext());
        priorNode.setNext(insertNode);
        size++;
        return this;
    }

    @Override
    public T removeFirst() throws IllegalStateException {
        if(isEmpty()) throw new IllegalStateException();

        if(size == 1){
            Node<T> tempNode = head;
            head = null;
            tail = null; 
            size--; 
            return tempNode.getData(); 
        }else{
        
        Node<T> tempNode = head;
        head = head.getNext();
        size--; 
        return tempNode.getData();
        }
    }

    @Override
    public T removeLast() throws IllegalStateException {
        if(isEmpty()){
            throw new IllegalStateException();  
        }

        if(size == 1){
            return removeFirst();
        }
        return removeAt(size - 1);
    }



    //Can be used for more than one method (multiple applications)
    @Override
    public T removeAt(int i) throws IndexOutOfBoundsException {
        if(i < 0 || i >= size){ 
            throw new IndexOutOfBoundsException(); 
        }
        if(i == 0){ 
            return removeFirst();
        }
        
        Node<T> priorNode = getHelper(i - 1,head); 
        T removedData = priorNode.getNext().getData(); 
        priorNode.setNext(priorNode.getNext().getNext()); 
        if(i == size-1){
            tail = priorNode; 
        }
        size--;
        return removedData; 
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
        if(i < 0 || i >= size){
             throw new IndexOutOfBoundsException();
        }
        return (getHelper(i,head).getData());
    }

    private Node<T> getHelper(int j,Node<T> currNode){
        if(j == -1) return head; 

        if(j == 0){
            return currNode;
        }

        return getHelper(j - 1,currNode.getNext());

    }

    @Override
    public boolean remove(T elem) throws NullPointerException {
        if(elem == null)throw new NullPointerException();

        if(head.getData().equals(elem)){
            removeFirst();
            return true; 
        }
        if(tail.getData().equals(elem)){
            removeLast();
            return true;
        }
       
        return removeHelper(elem,head,head);
    }

    private boolean removeHelper(T elem,Node<T> currNode,Node<T> prevNode){
        if(currNode.getNext() == null && !currNode.getData().equals(elem))return false;

        if(currNode.getData().equals(elem)){
            prevNode.setNext(currNode.getNext());
            size--; 
            return true; 
        }
        return removeHelper(elem,currNode.getNext(),currNode);
    }

    public int indexOf(T elem) throws NullPointerException {
        
        if(elem == null) throw new NullPointerException();
        
        if(isEmpty()) return -1;

        if(head.getData().equals(elem))return 0;

        return indexOfHelper(head,0,elem);

    }

    private int indexOfHelper(Node<T> currNode,int num,T elem){

        if(currNode.getNext() == null) return -1;
 
        if(currNode.getNext().getData().equals(elem)) return num + 1;

        return indexOfHelper(currNode.getNext(),num + 1,elem);

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator(){
        return null;
    }

}