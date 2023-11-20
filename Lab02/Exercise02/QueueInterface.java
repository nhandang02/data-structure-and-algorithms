public interface QueueInterface<E> {
    public void Enqueue(E item);
    public E Dequeue();
    public int size();
    public boolean contains(E item);
    public void print();
    public boolean isEmpty();
    public E getFront();
}