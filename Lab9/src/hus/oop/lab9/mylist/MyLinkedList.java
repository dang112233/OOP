package hus.oop.lab9.mylist;

public class MyLinkedList extends MyAbstractList {
    MyLinkedListNode head;
    int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    private MyLinkedListNode getNodeByIndex(int index) {
        MyLinkedListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    @Override
    public void add(Object o) {
        add(o, size);
    }

    @Override
    public void add(Object o, int index) {
        checkBounds(index, size);
        if (index == 0) {
            head = new MyLinkedListNode(0, head);
        } else {
            MyLinkedListNode current = getNodeByIndex(index - 1);
            current.setNext(new MyLinkedListNode(o, current.getNext()));
        }
        size++;
    }
    @Override
    public Object get(int index) {
        checkBounds(index, size -1);
        MyLinkedListNode node = getNodeByIndex(index);
        return node.getPayload();
    }

    public void remove(int index) {
        checkBounds(index, size - 1);
        if (index == 0) {
            head = head.getNext();
        } else {
            MyLinkedListNode current = getNodeByIndex(index - 1);
            current.setNext(current.getNext().getNext());
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }
}
