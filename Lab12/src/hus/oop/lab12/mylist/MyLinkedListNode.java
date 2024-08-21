package hus.oop.lab12.mylist;

public class MyLinkedListNode {
    private Object payload;
    private MyLinkedListNode next;

    public MyLinkedListNode(Object payload) {
        this.payload = payload;
        this.next = null;
    }

    public MyLinkedListNode(Object payload, MyLinkedListNode next) {
        this.payload = payload;
        this.next = next;
    }

    public Object getPayload() {
        return payload;
    }

    public MyLinkedListNode getNext() {
        return next;
    }

    public void setNext(MyLinkedListNode node) {
        this.next = node;
    }
}
