import java.util.Iterator;

/**
 * ArrayQueueIterator allows iterating over an ArrayQueue.
 * @param <E> generic type for ArrayQueueIterator.
 */
public class ArrayQueueIterator<E extends Cloneable> implements Iterator<E> {
    private ArrayQueue<E> arrayQueue;
    private int index;

    /**
     * Initialize a new array queue iterator.
     * @param arrayQueue - the array queue to iterate.
     */
    public ArrayQueueIterator(ArrayQueue<E> arrayQueue){
            this.arrayQueue = arrayQueue;
            this.index = 0;
    }

    /**
     * Returns true if the iteration has more elements, false otherwise.
     * @return true if the iteration has more elements, false otherwise.
     */
    @Override
    public boolean hasNext() {
        return (this.index < this.arrayQueue.getCapacity() && arrayQueue.getElement(index) != null);
    }

    /**
     * Returns the next element in the iteration.
     * @return the next element in the iteration.
     */
    @Override
    public E next() {
        E element = (E)this.arrayQueue.getElement(index);
        index++;
        return element;
    }
}
