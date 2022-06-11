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
            if (front == -1) { // Addition to empty Queue
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
        return (Cloneable) data[index];
    }

    @Override
    public ArrayQueue clone() {
        try{
            ArrayQueue copy = (ArrayQueue) super.clone(); //casting
            copy.data = data.clone();
            return copy;
        }
        catch (CloneNotSupportedException e){
            return null;
        }

    }

    @Override
    public Iterator iterator() {
        return new ArrayQueueIterator<E>(this);
    }
}
