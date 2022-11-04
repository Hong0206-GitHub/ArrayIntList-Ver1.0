import java.util.Arrays;

public class ArrayIntList {

    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private int[] element;

    public ArrayIntList() {
        size = 0;
        element = new int[DEFAULT_CAPACITY];
    }

    public ArrayIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity cannot be negative: " + capacity);
        }
        size = 0;
        element = new int[capacity];
    }



    public void add(int value) {
        checkResize();
        element[size] = value;
        size++;
    }

    public void add(int index, int value) {
        checkIndex(index, 0, size);
        checkResize();
        
        for (int i = size; i > index; i--) {
            element[i] = element[i - 1];
        }
        element[index] = value;
        size++;
    }

    private void checkResize() {

        if (size >= element.length)
            element = Arrays.copyOf(element, element.length * 2);
    }

    public int get(int index) {
        checkIndex(index, 0, size - 1);
        return element[index];
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    public void remove(int index) {
        checkIndex(index, 0, size - 1);
        for (int i = index; i < size; i++) {
            element[i] = element[i + 1];
        }
        size--;
    }

    public void set(int index, int value) {
        checkIndex(index, 0, size - 1);
        element[index] = value;
    }

    public int size() {
        return size;
    }

    public int indexOf(int value) {
        
        for (int i = 0; i < size; i++) {
            if (element[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int value) {
        if (indexOf(value) < 0)
            return false;
        else
            return true;
    }


    private void checkIndex(int index, int min, int max) {
        if (index < min || index > max) {
            throw new ArrayIndexOutOfBoundsException("Wrong index: " + index);
        }
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (size == 0)
            return "[]";
        else
            for (int i = 0; i < size; i++) {
                sb.append(element[i]);
                if (i < size - 1)
                    sb.append(", ");
            }
        sb.append("]");
        return sb.toString();
    }
}