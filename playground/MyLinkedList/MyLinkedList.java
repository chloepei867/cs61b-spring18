import java.util.List;

public class MyLinkedList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private int size;
    private IntNode sentinel;

    public MyLinkedList() {
        sentinel = new IntNode(777, null);
        size = 0;
    }


    public int get(int index) {
        IntNode temp = getNode(index);
        if (temp == null) {
            return -1;
        } else {
            return temp.item;
        }

    }

    private IntNode getNode(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        IntNode p = sentinel;
        for (int i = 0; i <= index; i += 1) {
            p = p.next;
        }
        return p;
    }

    public void addAtHead(int val) {
        sentinel.next = new IntNode(val, sentinel.next);
        size += 1;
    }

    public void addAtTail(int val) {
        IntNode p = sentinel.next;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(val, null);
        size += 1;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        IntNode p = sentinel;
        for (int i = 0; i < index; i += 1) {
            p = p.next;
        }
        p.next = new IntNode(val, p.next);

    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            sentinel.next = sentinel.next.next;
            size -= 1;
            return;
        }
        IntNode temp = getNode(index - 1);
        temp.next = temp.next.next;
        size -= 1;
    }

    public static void main(String[] args) {
        MyLinkedList L = new MyLinkedList();
        //L.addAtHead(1);
        L.addAtTail(1);
        //L.addAtIndex(1, 2);
        //L.get(1);
        //L.deleteAtIndex(1);
        //L.get(1);
    }
    
}