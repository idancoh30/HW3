import java.util.Iterator;

public class ArrayQueueIterator<E extends Cloneable> implements Iterator<E> {
    private ArrayQueue<E> arrayQueue;
    private int index;

    public ArrayQueueIterator(ArrayQueue<E> arrayQueue){
        this.arrayQueue = arrayQueue;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return (this.index < this.arrayQueue.getCapacity());
    }
    @Override
    public E next() {
        return (E)this.arrayQueue.getElement(index+1);
    }

//    @Override
//    public void remove() {
//        Iterator.super.remove();
//    }


}
