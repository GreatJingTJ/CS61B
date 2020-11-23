public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int start_pos, end_pos;

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(this.array, 0, a, 0, this.array.length);
        this.array = a;
    }

    public void addFirst(T item) {
        if (this.size == array.length) {
            this.resize(this.size + 1);
        }
        if(this.start_pos - 1 == -1){
            this.start_pos = this.array.length;
        }
        this.start_pos -= 1;
        this.array[this.start_pos] = item;

        this.size += 1;
    }

    public void addLast(T item) {
        if (this.size == this.array.length) {
            this.resize(this.size + 1);
        }
        if(this.end_pos + 1 == this.array.length){
            this.end_pos = 0;
        }
        this.array[this.end_pos] = item;
        this.end_pos += 1;
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
        if(this.start_pos == this.array.length){
            this.start_pos = 0;
        }

        T ans = this.array[this.start_pos];
        if(this.start_pos + 1 <= this.array.length){
            this.start_pos += 1;
        }

        this.size -= 1;
       return ans;
    }

    public T removeLast() {
        if (this.size == 0) {
            return null;
        }
        T ans;
        if(this.end_pos == 0){
            this.end_pos = this.array.length - 1;
            ans = this.array[this.end_pos];
        } else {
            ans = this.array[this.end_pos - 1];
        }
        this.end_pos -= 1;
        this.size -= 1;
        return ans;
    }

    private void printD() {
        if (start_pos < end_pos ) {
            for (int i = this.start_pos; i < this.end_pos; i++) {
                System.out.print(this.array[i] + " ");
            }
        } else {
            for (int i = this.start_pos; i < this.array.length; i++) {
                System.out.print(this.array[i] + " ");
            }

            for (int i = 0; i < this.end_pos; i++) {
                System.out.print(this.array[i] + " ");
            }
        }
        System.out.print("\n");
    }


    public T get(int index) {
        if(start_pos < end_pos){
            return this.array[this.start_pos + index];
        }else{
            return this.array[this.array.length - this.start_pos + index];
        }
    }

    public ArrayDeque() {
        this.array = (T[]) new Object[8];
        this.size = 0;
        this.start_pos = 8;
        this.end_pos = 0;
    }

    private ArrayDeque(ArrayDeque other) {
        this.start_pos = 8;
        this.end_pos = 0;
        this.array = (T[]) new Object[8];
        this.size = 0;

        for (int i = 0; i < other.size(); i++) {
            this.addLast((T) other.get(i));
        }
    }

    private static void main(String[] args) {
        ArrayDeque<Integer> mylist = new ArrayDeque<>();

        for (int i = 0; i < 5; i++) {
            mylist.addLast(i);
        }
        mylist.printD();
        ArrayDeque<Integer> mylist2 = new ArrayDeque<>(mylist);
        mylist2.removeLast();
        mylist2.printD();
    }
}
