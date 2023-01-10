package list.linked_list;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList(5);
        linkedList.addFirst(6);
        linkedList.printList();
        linkedList.addFirst(7);
        linkedList.addFirst(10);
        linkedList.printList();
        linkedList.add(2, 20);
        linkedList.remove(3);
        linkedList.printList();
    }
}
