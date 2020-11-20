public class LinkedListDeque <T> {
    private int size;
    private T type;
    private Node firstEmptyNode = new Node(null, null, null);
    private Node lastEmptyNode = new Node(null, null, null);
    public LinkedListDeque(){
        size = 0;
        firstEmptyNode.next = lastEmptyNode;
        lastEmptyNode.prev = firstEmptyNode;
    }

    public LinkedListDeque(LinkedListDeque other){
        size = 0;
        firstEmptyNode.next = lastEmptyNode;
        lastEmptyNode.prev = firstEmptyNode;

        for(int i = 0; i < other.size(); i++){
            this.addLast((T)other.get(i));
        }
    }

    public static void main(String[] args){
        LinkedListDeque<Integer> mylist = new LinkedListDeque<>();
        System.out.print(mylist.isEmpty());
        mylist.addLast(1);

        mylist.removeFirst();

        LinkedListDeque<Integer> mylist2 = new LinkedListDeque<>(mylist);
        mylist2.printDeque();
    }

    private T helper_func(int index, Node node){
        if(index == 0){
            return node.val;
        }
        return helper_func(index - 1, node.next);
    }

    public void addFirst(T item){
        firstEmptyNode.next = new Node(firstEmptyNode, item, firstEmptyNode.next);
        firstEmptyNode.next.next.prev = firstEmptyNode.next;
        if(size == 0){
            lastEmptyNode.prev = firstEmptyNode.next;
        }
        this.size += 1;
    }

    public void addLast(T item){
        lastEmptyNode.prev = new Node(lastEmptyNode.prev, item, lastEmptyNode.next);
        lastEmptyNode.prev.prev.next = lastEmptyNode.prev;

        if(size == 0){
            firstEmptyNode.next = lastEmptyNode.prev;
        }

        this.size += 1;
    }

    public T removeFirst(){
        if(size == 0){
            return null;
        } else if(size == 1){
            T val = firstEmptyNode.next.val;
            firstEmptyNode.next = null;
            this.size -= 1;
            return val;
        }
        T val = firstEmptyNode.next.val;
        firstEmptyNode.next = firstEmptyNode.next.next;
        firstEmptyNode.next.prev = firstEmptyNode;
        this.size -= 1;
        return val;
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        T val = lastEmptyNode.prev.val;
        lastEmptyNode.prev = lastEmptyNode.prev.prev;
        lastEmptyNode.prev.next = lastEmptyNode;
        this.size -= 1;
        return val;
    }

    public void printDeque(){
        Node node = firstEmptyNode.next;

        while(node != null && node.val != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.print("\n");
    }

    public T get(int x){
        Node node = firstEmptyNode.next;

        for(int i = 0; i < x; i++){
            node = node.next;
        }
        return node.val;
    }

    public T getRecursive(int index){
        return helper_func(index, firstEmptyNode.next);
    }

    public boolean isEmpty(){
        return (this.size == 0);
    }

    public int size() {
        return this.size;
    }

    private class Node{
        T val;
        Node next;
        Node prev;
        Node(Node prev, T val, Node next){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }


}
