package structures;

public class RecursiveList<T> implements ListInterface<T> {

    private int size;


    public RecursiveList(){

    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public RecursiveList<T> insertFirst(T elem){
        return this;
    }

    @Override
    public RecursiveList<T> insertLast(T elem){

        return this;
    }

    @Override
    public ListInterface<T> insertAt(int index, T elem){

        return this;
    }

    @Override
    public T removeFirst(){

        return T; 
    }

    @Override
    public T removeLast(){

        return T; 
    }

    @Override
    public T getFirst(){

        return T;
    }

    @Override
    public T getLast(){

        return T;
    }

    @Override
    public T get(int i){

        return T;
    }

    @Override
    public boolean remove(T elem){

        return true;
    }

    @Override
    public boolean isEmpty(){
        return head == null; 
    }

}