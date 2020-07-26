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
    public ListInterface<T> insertAt(int index, T elem)throws NullPointerException, IndexOutOfBoundsException {
        if(elem == null)throw new NullPointerException();
        if(index < 0 || index > size)throw new IndexOutOfBoundsException(); 
        Node<T> insertAt = getHelper(index-1,head);
        Node<T> insertedElem = new Node<T>(elem,insertAt.getNext()); 
        if(isEmpty()){
            this.insertFirst(elem); 
            return this; 
        }
        insertedElem.setNext(insertAt.getNext());
        insertAt.setNext(insertedElem);
        size++;
        return this;
    }

    @Override
    public T removeFirst() throws IllegalStateException {
        if(isEmpty()) throw new IllegalStateException();

        if(size == 1){
            head = null;
            return null; 
        }else{
        
        Node<T> tempNode = head;
        head = head.getNext();
        tempNode.setNext(null);
        size--; 
        return tempNode.getData();
        }
    }

    @Override
    public T removeLast() throws IllegalStateException {
        if(isEmpty())throw new IllegalStateException();  

        if(size == 1){
            Node<T> tempNode = head;
            head = null;
            tail = null; 
            size--;
            return tempNode.getData(); 
        }
        return removeLastHelper(head,0);
    }

    private T removeLastHelper(Node<T> currNode,int numNode){

        if(numNode == size -2){
            T data = currNode.getNext().getData();
            currNode.setNext(null);
            tail = currNode;
            size--;
            return data; 
        }
        return removeLastHelper(currNode.getNext(),numNode + 1);
    }

    @Override
    public T removeAt(int i) throws IndexOutOfBoundsException {
        if(i < 0 || i > size) throw new IndexOutOfBoundsException(); 
        if(i == size - 1) return removeLast(); 
        if(i == 0) return getFirst();
        Node<T> start = head; 
        Node<T> seccond = null; 

        return removeAtHelper(start,seccond,i);   
    }

    private T removeAtHelper(Node<T> start,Node<T> seccond,int i){
        if(i == 0){
            start.setNext(start.getNext().getNext()); 
            return start.getData(); 
        }
        return removeAtHelper(start.getNext(),start,i-1);
    }
        //If does not work use the getHelper method instead

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

        return getHelper(i,head).getData();
    }

    private Node<T> getHelper(int j,Node<T> newHead){

        if(j == 0){
            return newHead;
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

    public int indexOf(T elem) throws NullPointerException {
        
        if(elem == null) throw new NullPointerException();
        
        if(head == null) return -1;

        return indexOfHelper(head,0,elem);

    }

    private int indexOfHelper(Node<T> head,int num,T elem){
        if(isEmpty()) return -1; //empty list
        
        if(num == size - 1) return -1;

        if(head.getData().equals(elem)) return num; 

        return indexOfHelper(head.getNext(),++num,elem);


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