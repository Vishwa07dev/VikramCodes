public class TestLL {

  public static void main(String[] args) {

    //Creating a linkedList
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    node1.setNext(node2);
    ListNode node3 = new ListNode(3);
    node2.setNext(node3);
    ListNode node4 = new ListNode(4);
    node3.setNext(node4);
    ListNode node5 = new ListNode(5);
    node4.setNext(node5);

    MyLinkedList ll = new MyLinkedList(node1);

    ll.traverse(node1);
    System.out.println("####");

    ListNode newHead = ll.insert(node1, 77, 10);

    ll.traverse(newHead);

    System.out.println("####");


    newHead = ll.insert(node1, 77, 3);
    ll.traverse(newHead);

  }
}
