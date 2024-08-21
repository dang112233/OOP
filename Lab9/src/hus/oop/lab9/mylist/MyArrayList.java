package hus.oop.lab9.mylist;

public class MyArrayList extends MyAbstractList {
    static final int INITIAL_SIZE = 16;
    Object[] elements;
    int size;

    public MyArrayList() {
        elements = new Object[INITIAL_SIZE];
        size = 0;
    }

    @Override
    public void add(Object o) {
        if (size >= elements.length - 1) {
            enlarge();
        }
        elements[size++] = o;
    }

    @Override
    public void add(Object o, int index) {
        checkBounds(index, size);
        if (size >= elements.length - 1) {
            enlarge();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = o;
        size++;
    }

    @Override
    public Object get(int index) {
        checkBounds(index, size - 1);
        return elements[index];
    }

    @Override
    public void remove(int index) {
        checkBounds(index, size - 1);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    void enlarge() {
        Object[] tmp = new Object[elements.length * 2];
        System.arraycopy(elements, 0, tmp, 0, elements.length);
        elements = tmp;
    }
}

