public interface Deque<T> {
    public void addFirst(T item);
    public T removeFirst();
    public void addLast(T item);
    public T removeLast();
    public int size();
    default boolean isEmpty(){
        if (size() == 0){
            return true;
        }
        return false;
    };
    public T get(int index);
    public void printDeque();
}
