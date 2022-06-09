import java.lang.reflect.Array;
import java.util.Iterator;

public class ArrayQueue<E extends Cloneable> implements Queue {

    private int front;
    private int rear;
    private int numElements;
    private int capacity;
    private Cloneable[] data;

    public ArrayQueue(int capacity)
    {
        data = (Cloneable[]) new Object[capacity];
        rear = 0;
        front = 0;
        numElements = 0;
    }

    @Override
    public boolean isEmpty() {
        return (numElements == 0);
    }

    public int size()
    {
        return numElements;
    }

    @Override
    public Cloneable peek()
    {
        return data[front];
    }

    public Cloneable dequeue()
    {
        Cloneable head = data[front];
        data[front] = null;
        front +=1;
        return head;
    }

    @Override
    public void enqueue(Cloneable element) {
        if (numElements < capacity) {
            rear += 1;
            data[rear] = element;
            numElements++;
        }
        else{
            throw new QueueOverflowException();
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public Cloneable getElement(int index)
    {
        return (Cloneable)data[index];
    }

    @Override
    public Queue clone() {
        return null;
    }

    @Override
    public Iterator iterator() {
        return new ArrayQueueIterator<E>(this);
    }
}
