import java.util.Iterator;

public class ArrayQueueIterator<E> implements Iterator<E> {
    private E element;

    public ArrayQueueIterator(E element) {
        this.element = element;
    }

    @Override
    public E next() {
        return null;
    }

//    @Override
//    public void remove() {
//        Iterator.super.remove();
//    }

    @Override
    public boolean hasNext() {
        return false;
    }


}
