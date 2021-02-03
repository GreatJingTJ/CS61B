public class LinkedListDeque<T> {
    private final Node first;
    private final Node last;
    private int size;

    public static void main(String[] args) {

    }
    
    public LinkedListDeque() {
        T item = null;
        first = new Node(null, null, null);
        last = new Node(null, null, null);
        first.next = last;
        last.prev = first;
    }

    public LinkedListDeque(LinkedListDeque other) {
        first = new Node(null, null, null);
        last = new Node(null, null, null);
        first.next = last;
        last.prev = first;

        for (int i = 0; i < other.size(); i++) {
            this.addLast((T) other.get(i));
        }
    }

    public int size() {
        return this.size;
    }

    public void addFirst(T item) {
        first.next = new Node(first, item, first.next);

        if (first.next.next != null) {
            first.next.next.prev = first.next;
        }

        if (size == 0) {
            last.prev = first.next;
        }

        this.size += 1;
    }

    public void addLast(T item) {

        last.prev = new Node(last.prev, item, last);

        if (last.prev.prev != null) {
            last.prev.prev.next = last.prev;
        }

        if (this.size == 0) {
            first.next = last.prev;
        }

        this.size += 1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T removeFirst() {
        if (this.size == 0) {
            return null;
        } else if (this.size == 1) {
            this.size -= 1;
            T itemVal = this.first.next.item;
            this.first.next = this.last.prev;
            return itemVal;
        } else {
            this.size -= 1;
            T itemVal = this.first.next.item;
            this.first.next = this.first.next.next;
            this.first.next.prev = this.first;

            return itemVal;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T itemVal = last.prev.item;
            last.prev = last.prev.prev;
            last.prev.next = last;
            this.size -= 1;
            return itemVal;
        }
    }

    public void printDeque() {
        var node = this.first.next;
        while (node != null && node.item != null) {
            System.out.print(node.item + " ");
            node = node.next;
        }
        System.out.println();
    }

    public T get(int index) {
        var node = this.first.next;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    private T getRecursive_helper(int index, Node node) {
        if (index == 0) {
            return node.item;
        } else {
            return getRecursive_helper(index - 1, node.next);
        }
    }

    public T getRecursive(int index) {
        var node = this.first.next;
        return getRecursive_helper(index, node);
    }

    public class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(Node prev, T item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

}
