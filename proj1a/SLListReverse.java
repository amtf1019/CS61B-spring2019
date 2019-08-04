import javax.swing.plaf.synth.SynthTextAreaUI;

/* Discussion Q1. */
public class SLListReverse {

    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void reverse(){
        if (first == null || first.next == null){
            return;
        }
        IntNode p = first.next;
        first.next = null;

        while (p != null) {
            IntNode temp = p.next;
            p.next = first;
            first = p;
            p = temp;
        }
    }

    public int getFirst(){
        return first.item;
    }

    public static void main(String[] args) {
        SLListReverse L = new SLListReverse();
        L.addFirst(15);
        L.addFirst(10);
        L.addFirst(5);
        L.reverse();
        System.out.println(L.getFirst());
    }
}