public class LinkedListDeque<T> {

    private class TNode {
        public T item;
        public TNode prev;
        public TNode next;

        public TNode(TNode p, T i, TNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /* Declaring variable. */
    private TNode sentinel;
    private int size;

    /* Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new TNode (null, null, null);
        /* circular sentinel. */
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /* Creates a deep copy of other. */
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new TNode (null, null, null);
        /* circular sentinel. */
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
        }
    }

    /* Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        size += 1;
        sentinel.next = new TNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
    }

    /* Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        size += 1;
        sentinel.prev = new TNode(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last,
       separated by a space. Once all the items have been printed,
       print out a new line.*/
    public void printDeque() {
        TNode prt = sentinel;
        while (prt.next != sentinel) {
            prt = prt.next;
            System.out.print(prt.item);
            System.out.print(" ");
        }
        System.out.println();
    }

    /* Removes and returns the item at the front of the deque.
       If no such item exists, returns null.*/
    public T removeFirst() {
        if (size == 0)
            return null;
        T firstItem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        size -= 1;
        return firstItem;
    }

    /* Removes and returns the item at the back of the deque.
       If no such item exists, returns null.*/
    public T removeLast() {
        if (size == 0)
            return null;
        T lastItem = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.prev.next = sentinel;
        size -= 1;

        return lastItem;
    }

    /*  Gets the item at the given index,
        where 0 is the front, 1 is the next item,
        and so forth. If no such item exists, returns null.
        Must not alter the deque! */
    public T get(int index) {
        TNode p = sentinel;
        int count = 0;
        while (p.next != null) {
            p = p.next;
            if (count == index)
                return p.item;
            count ++;
        }
        return null;
    }

    public T getRecursive(int index) {
        if (index >= size)
            return null;
        return traverse(sentinel.next, index);

    }

    private T traverse(TNode n, int i){
        if (i == 0)
            return n.item;
        return traverse(n.next, i - 1);
    }

}