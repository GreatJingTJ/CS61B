public class LinkedListDeque<Type> {
    private class Node {
        Type item;
        Node next;
        Node prev;

        Node(Type item, Node next, Node prev) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private Type type;
    private int size;
    private Node firstNode = new Node(type, null, null), lastNode = new Node(type, null, null);

    public LinkedListDeque() {
        this.size = 0;
        firstNode.next = lastNode;
        lastNode.prev = firstNode;
    }


    public void addFirst(Type item) {
        this.size += 1;
        firstNode.next = new Node(item, firstNode.next, firstNode);
    }

    public void addLast(Type item) {
        this.size += 1;
        lastNode.prev = new Node(item, lastNode, lastNode.prev);
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }
    
    public int size() {
        return this.size;
    }

    public Type removeFirst() {
        if (size == 0) {
            return null;
        } else {
            size -= 1;
            Type ans = firstNode.item;
            firstNode = firstNode.next;
            return ans;
        }
    }

    public Type removeLast() {
        if (size == 0) {
            return null;
        } else {
            size -= 1;
            Type ans = lastNode.item;
            lastNode = lastNode.prev;
            return ans;
        }
    }

    public Type get(int x) {
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

    private Type recursionHelper(int index, Node node) {
        if (index == 0) {
            return node.item;
        } else {
            return recursionHelper(index - 1, node.next);
        }
    }

    public Type getRecursive(int index) {
        return recursionHelper(index, firstNode.next);
    }

    public LinkedListDeque(LinkedListDeque other) {
        this.size = other.size();
        firstNode.next = lastNode;
        lastNode.prev = firstNode;

        for (int i = 0; i < size; i++) {
            this.addLast((Type) other.get(i));
        }

    }


    public static void main(String[] args) {


    }


}
