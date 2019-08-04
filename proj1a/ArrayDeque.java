public class ArrayDeque<Item> {

    /* Create instance variable. */
    private Item[] items;
    private int size;
    private int nextFirst; /* index number */
    private int nextLast;

    /* Creates an empty array deque. */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    /* Creates a deep copy of other. */
    public ArrayDeque(ArrayDeque other) {
        Item[] a = (Item[]) new Object[other.size];
        System.arraycopy(other.items, 0, a, 0, size);
    }

    private int adjustFirst(int index) {
        if (index < 0) {
            return items.length - 1;
        }
        return index - 1;
    }

    private int adjustLast(int index) {
        if (index >= items.length) {
            return 0;
        }
        return index + 1;
    }

    public void resize() {
        if (size == items.length) {
            Item[] a = (Item[]) new Object[items.length * 2];
            System.arraycopy(items, 0, a, 0, size);
            items = a;
        }
        if (size < items.length / 2) {
            Item[] a = (Item[]) new Object[items.length / 2];
            System.arraycopy(items, 0, a, 0, size);
            items = a;
        }
    }

    /* Adds an item of type T to the front of the deque. */
    public void addFirst(Item x) {
        resize();
        items[nextFirst] = x;
        nextFirst = adjustFirst(nextFirst);
        size++;
    }

    /* Adds an item of type T to the back of the deque. */
    public void addLast(Item x) {
        resize();
        items[nextLast] = x;
        nextLast = adjustLast(nextLast);
        size++;
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
        for (int i = 0; i < size; i++) {
            System.out.print(items[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    /* Removes and returns the item at the front of the deque.
       If no such item exists, returns null.*/
    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        Item first = items[0];
        Item[] a = (Item[]) new Object[size - 1];
        System.arraycopy(items, 0, a, 0, size - 1);
        items = a;
        resize();
        size--;
        return first;
    }

    /* Removes and returns the item at the back of the deque.
       If no such item exists, returns null.*/
    public Item removeLast() {
        if (size == 0)
            return null;
        Item last = items[size - 1];
        Item[] a = (Item[]) new Object[size - 1];
        System.arraycopy(items, 0, a, 0, size - 1);
        items = a;
        resize();
        size--;
        return last;
    }

    /*  Gets the item at the given index,
        where 0 is the front, 1 is the next item,
        and so forth. If no such item exists, returns null.
        Must not alter the deque! */
    public Item get(int index) {
        if (index >= size || index < 0)
            return null;
        return items[index];
    }
}