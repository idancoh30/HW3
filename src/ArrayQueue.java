import java.util.Iterator;

public class ArrayQueue<E extends Cloneable> implements Queue<E> {

    private int front;
    private int rear;
    private int numElements;
    private int capacity;
    private Cloneable[] data;

    public ArrayQueue(int capacity)
    {
        if(capacity < 0)
            throw new NegativeCapacityException();
        this.capacity = capacity;
        this.data = new Cloneable[capacity];
        this.rear = 0;
        this.front = 0;
        this.numElements = 0;
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
    public E peek()
    {
        return (E)data[front];
    }

    public E dequeue()
    {
        Cloneable head = data[front];
        data[front] = null;
        front +=1;
        return (E)head;
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
