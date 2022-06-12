import java.lang.reflect.Method;
import java.util.Iterator;

public class ArrayQueue<E extends Cloneable> implements Queue<E> {
    private int front;
    private int rear;
    private int numElements;
    private int capacity;
    private Cloneable[] data;


    public ArrayQueue(int capacity) {
        if (capacity < 0)
            throw new NegativeCapacityException();
        this.capacity = capacity;
        this.data = new Cloneable[capacity];
        this.rear = -1;
        this.front = -1;
        this.numElements = 0;
    }

    public boolean isFull() {
        return (numElements == capacity);
    }

    @Override
    public boolean isEmpty() {
        return (numElements == 0);
    }

    public int size() {
        return numElements;
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new EmptyQueueException();
        return (E) data[front];
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        Cloneable dequeued = data[front];
        if (front == rear) {
            data[front] = null;
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        numElements--;
        return (E) dequeued;
    }

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

    public int getCapacity() {
        return capacity;
    }

    public Cloneable getElement(int index) {
        return data[index];
    }

    @Override
    public ArrayQueue<E> clone() {
        try {
            ArrayQueue<E> copy = (ArrayQueue<E>)super.clone();
            Cloneable[] copiedData = new Cloneable[this.capacity];
            for(int i = 0; i < this.capacity; i++){
                if (data[i] != null) {
                    Class metaClass = data[i].getClass();
                    Method m = metaClass.getMethod("clone");
                    copiedData[i] = (Cloneable)m.invoke(data[i]);
                }
            }
            copy.data = copiedData;
            return copy;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Iterator iterator() {
        return new ArrayQueueIterator(this);
    }
}
