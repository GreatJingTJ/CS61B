public class ArrayDeque<T> {
    private T[] array;
    private int size;

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(this.array, 0, a, 0, this.array.length);
        this.array = a;
    }

    public void addFirst(T item) {
        if (this.size == array.length) {
            this.resize(this.size + 1);
        }
        if (this.size == 0) {
            this.array[0] = item;
            this.size += 1;
            return;
        }
        System.arraycopy(this.array, 0, this.array, 1, this.array.length - 1);
        this.array[0] = item;
        this.size += 1;
    }

    public void addLast(T item) {
        if (this.size == this.array.length) {
            this.resize(this.size + 1);
        }
        this.array[this.size] = item;
        this.size += 1;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.array[i] + " ");
        }

        System.out.print("\n");
    }

    public T removeFirst() {
        if (this.size == 0) {
            return null;
        }
        T ans = this.array[0];
        System.arraycopy(this.array, 1, this.array, 0, this.array.length - 1);
        this.size -= 1;
        return ans;
    }

    public T removeLast() {
        if (this.size == 0) {
            return null;
        }
        T ans = this.array[this.size - 1];
        System.arraycopy(this.array, 0, this.array, 0, this.array.length - 1);
        this.size -= 1;
        return ans;
    }

    private void printD() {

        for (int i = 0; i < this.size; i++) {

            System.out.print(this.array[i] + " ");
        }
    }

    public T get(int index) {
        return this.array[index];
    }

    public ArrayDeque() {
        this.array = (T[]) new Object[8];
        this.size = 0;
    }

    private ArrayDeque(ArrayDeque other) {

        this.array = (T[]) new Object[other.size()];
        this.size = 0;

        for (int i = 0; i < other.size(); i++) {
            this.addLast((T) other.get(i));
        }
    }

    private static void main(String[] args) {
        ArrayDeque<Integer> mylist = new ArrayDeque<>();

        for (int i = 0; i < 5; i++) {
            mylist.addFirst(i);
        }
        ArrayDeque<Integer> mylist2 = new ArrayDeque<>(mylist);
        mylist2.removeFirst();
        mylist2.printD();
    }
}
