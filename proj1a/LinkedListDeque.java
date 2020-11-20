public class LinkedListDeque<T> {
    private class Node {
        T item;
        Node next;
        Node prev;

        Node(T item, Node next, Node prev) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private T T;
    private int size;
    private Node firstNode = new Node(T, null, null), lastNode = new Node(T, null, null);

    public LinkedListDeque() {
        this.size = 0;
        firstNode.next = lastNode;
        lastNode.prev = firstNode;
    }


    public void addFirst(T item) {
        this.size += 1;
        firstNode.next = new Node(item, firstNode.next, firstNode);
    }

    public void addLast(T item) {
        this.size += 1;
        lastNode.prev = new Node(item, lastNode, lastNode.prev);
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }
    
    public int size() {
        return this.size;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            size -= 1;
            T ans = firstNode.item;
            firstNode = firstNode.next;
            return ans;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            size -= 1;
            T ans = lastNode.item;
            lastNode = lastNode.prev;
            return ans;
        }
    }

    public T get(int x) {
        if (x > size) {
            return null;
        }
        Node node = firstNode.next;

        for (int i = 0; i < x; i++) {
            node = node.next;
        }
        return node.item;
    }

    public void printDeque() {
        Node node = firstNode.next;
        while (node.next != null) {
            System.out.print(node.item + " ");
            node = node.next;
        }
        System.out.println("\n");
    }

    private T recursionHelper(int index, Node node) {
        if (index == 0) {
            return node.item;
        } else {
            return recursionHelper(index - 1, node.next);
        }
    }

    public T getRecursive(int index) {
        return recursionHelper(index, firstNode.next);
    }

    public LinkedListDeque(LinkedListDeque other) {
        this.size = other.size();
        firstNode.next = lastNode;
        lastNode.prev = firstNode;

        for (int i = 0; i < size; i++) {
            this.addLast((T) other.get(i));
        }

    }


    public static void main(String[] args) {


    }


}
