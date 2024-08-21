package hus.oop.mybookmanager;

import java.util.NoSuchElementException;

public class MyLinkedList extends AbstractMyList {
    private Node head;
    private int size;

    private class MyLinkedListIterator implements MyIterator {
        private Node currentNode;

        public MyLinkedListIterator(Node startNode) {
            this.currentNode = startNode;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Object next() {
            if (currentNode == null) {
                throw new NoSuchElementException();
            }
            Object data = currentNode.data;
            currentNode = currentNode.next;
            return data;
        }
    }

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(Object data, int index) {
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node node = getNodeByIndex(index);
        node.data = data;
    }

    /**
     * Thêm phần tử dữ liệu vào đầu tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(Object value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(Object value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     * Chỉ thêm được nếu index nằm trong đoạn [0 - size()].
     * @param value
     * @param index
     */
    @Override
    public void insertAtPosition(Object value, int index) {
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            insertAtStart(value);
        } else {
            Node newNode = new Node(value);
            Node prevNode = getNodeByIndex(index - 1);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            size++;
        }
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node prevNode = getNodeByIndex(index - 1);
            prevNode.next = prevNode.next.next;
        }
        size--;
    }

    /**
     * Phương thức lấy Node ở vị trí index.
     * @param index
     * @return Node tại vị trí index.
     */
    private Node getNodeByIndex(int index) {
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public MyIterator iterator() {
        return new MyLinkedListIterator(head);
    }
}
