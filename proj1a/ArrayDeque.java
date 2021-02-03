public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private final int firstPos = 0;
    private final int endPos = 8;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
    }

    public ArrayDeque(ArrayDeque other) {

        this.array = (T[]) new Object[other.size()];
        this.size = 0;

        for (int i = 0; i < other.size(); i++) {
            this.addLast((T) other.get(i));
        }
    }

    private static void main(String[] args) {
        ArrayDeque<Integer> myarray = new ArrayDeque<Integer>();

        for (int i = 0; i < 5; i++) {
            myarray.addFirst(i);
        }
        myarray.printList();
    }

    private void resize(int n) {
        T[] newarray = (T[]) new Object[n];
        System.arraycopy(array, 0, newarray, 0, array.length);
        this.array = newarray;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFirst(T item) {
        if (this.size == this.array.length) {
            this.resize(this.size + 1);
        }

        if (this.size == 0) {
            this.array[0] = item;
            this.size += 1;
        } else {
            System.arraycopy(array, 0, array, 1, array.length - 1);
            array[0] = item;
            this.size += 1;
        }
    }

    public void addLast(T item) {
        if (this.size == this.array.length) {
            this.resize(this.size + 1);
        }
        this.array[this.size] = item;
        this.size += 1;
    }

    public void printDeque() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.array[i] + " ");
        }

        System.out.print("\n");
    }

    public T removeFirst() {
        if (this.size() == 0) {
            return null;
        }
        T itemVal = this.array[0];
        System.arraycopy(array, 1, array, 0, this.size - 1);
        this.size -= 1;
        return itemVal;
    }

    public T removeLast() {
        if (this.size == 0) {
            return null;
        }
        T itemVal = this.array[this.size - 1];
        this.size -= 1;

        return itemVal;
    }

    public T get(int index) {
        return this.array[index];
    }

    private void printList() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.array[i] + " ");
        }

        System.out.print("\n");
    }

}
