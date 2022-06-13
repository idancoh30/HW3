import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * Queue to order elements in a FIFO (=First in first out) manner, implemented by cyclic array.
 * @param <E> Generic type for queue.
 */
public class ArrayQueue<E extends Cloneable> implements Queue<E> {
    private int front;
    private int rear;
    private int numElements;
    private int capacity;
    private Cloneable[] data;

    /**
     * Initialize new array queue.
     * @param capacity - maximum queue capacity.
     * @throws NegativeCapacityException if queue's given size is negative.
     */
    public ArrayQueue(int capacity) {
        if (capacity < 0)
            throw new NegativeCapacityException();
        this.capacity = capacity;
        this.data = new Cloneable[capacity];
        this.rear = -1; // track the last element of the queue, when queue is empty, rear is equal to -1.
        this.front = -1; // track the first element of the queue, when queue is empty, front is equal to -1.
        this.numElements = 0; // number of non-null elements in queue.
    }

    /**
     * Check whether queue is full.
     * @return true if queue is full, false otherwise.
     */
    public boolean isFull() {
        return (numElements == capacity);
    }

    /**
     * Check whether queue is empty.
     * @return true if queue is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return (numElements == 0);
    }

    /**
     * Returns number of non-null elements in queue.
     * @return number of non-null elements in queue.
     */
    public int size() {
        return numElements;
    }

    /**
     * Retrieves, but does not remove the head of the queue.
     * @return the head of the queue.
     * @throws EmptyQueueException if queue is empty.
     */
    @Override
    public E peek() {
        if (isEmpty())
            throw new EmptyQueueException();
        return (E) data[front];
    }

    /**
     * Retrieves, and removes the head of the queue.
     * @return the head of the queue.
     * @throws EmptyQueueException if queue is empty.
     */
    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        Cloneable dequeued = data[front];
        if (front == rear) { // Only one element in queue, when removing it queue will be restored to it's initial status.
            data[front] = null;
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        numElements--;
        return (E) dequeued;
    }

    /**
     * Inserts the specified element into the queue.
     * @param element - the element to be inserted into the queue.
     * @throws QueueOverflowException if queue is full.
     */
    @Override
    public void enqueue(E element) {
        if (isFull())
            throw new QueueOverflowException();
        else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % capacity;
            data[rear] = element;
            numElements++;
        }
    }

    /**
     * Returns the capacity of the queue.
     * @return queue's capacity.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns element at the specified index.
     * @param index - the index of the wanted element.
     * @return - the element in the given array's index.
     */
    public Cloneable getElement(int index) {
        return data[index];
    }

    /**
     * Creates and returns a deep copy of the queue.
     * @return deep copy of the queue.
     */
    @Override
    public ArrayQueue<E> clone() {
        try {
            ArrayQueue<E> copy = (ArrayQueue<E>)super.clone(); // Create shallow copy of array queue.
            Cloneable[] copiedData = new Cloneable[this.capacity];
            for(int i = 0; i < this.capacity; i++){
                if (data[i] != null) {
                    Class metaClass = data[i].getClass(); // get object's runtime class.
                    Method m = metaClass.getMethod("clone"); // get clone method of current object.
                    copiedData[i] = (Cloneable)m.invoke(data[i]);
                }
            }
            copy.data = copiedData;
            return copy;
        }
        catch (Exception e) // All possible exception are checked, thus inherits from Exception class.
        {
            return null;
        }
    }

    /**
     * Returns an iterator over the elements in the queue.
     * @return an iterator over the elements in the queue.
     */
    @Override
    public Iterator iterator() {
        return new ArrayQueueIterator(this);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(front, rear, numElements, capacity);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
