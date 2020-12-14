package linkedlist;

//**

/**
 *
 * 1. Fork the repo
 * 2. Download in the local machine
 * 3. Open in IDE --
 * 4. Make changes in your local
 * 5. Raise a pull request
 *
 *
 *
 *
 */

public class LinkedList {

  // 1-->2-->3--->4 --->null
  public static void traverse(ListNode head) {
    if (head == null) {
      return;
    }

    ListNode temp = head;

    while (temp != null) {
      System.out.print(temp.getData() + " -> ");
      temp = temp.getNext();
    }

    System.out.println();
  }


  public static int length(ListNode head){

    if (head == null) {
      return 0;
    }
    ListNode temp = head;
    int count = 0 ;
    while (temp != null) {
      count++;
      temp = temp.getNext();
    }

    return count ;


  }

  // 1-->2-->3 --->null

  public static ListNode insert(ListNode head , int data , int k){
    if(k<=0 || k>length(head)+1){
      System.out.println(k +" is invalid position");
      return head ;
    }

    if(head==null && k >1){
      return head ;
    }

    ListNode newNode = new ListNode(data);

    if(k==1){
      //it should be added at head
      newNode.setNext(head);
      head = newNode ;
      return head ;

    }else{

      ListNode temp = head ;
      int index =1 ;

      while(index < k-1){
        temp = temp.getNext();
        index++ ;
      }

      newNode.setNext(temp.getNext());
      temp.setNext(newNode);

      return head ;
    }

  }

  public static ListNode delete(ListNode head , int k){
    // TODO : Please implement this method
    return head ; // change this line accordingly
  }

  public static ListNode update(ListNode head , int k , int data){
    // TODO : Please implement this method
    return head ; // change this line accordingly
  }

  public static void main(String[] args) {
    ListNode<Integer> head = new ListNode<>(5);

    ListNode<Integer> node1 = new ListNode<>(7);
    ListNode<Integer> node2 = new ListNode<>(2);
    ListNode<Integer> node3 = new ListNode<>(3);

    head.setNext(node1);
    node1.setNext(node2);
    node2.setNext(node3);

    traverse(head);

    System.out.println(length(head));

    head = insert(head,9, length(head)+1);  // 5 7  2 3 9

    traverse(head);


  }
}

class ListNode<K> {

  private K data;
  private ListNode next;

  public ListNode(K data) {
    this.data = data;
  }

  public K getData() {
    return data;
  }

  public void setData(K data) {
    this.data = data;
  }

  public ListNode getNext() {
    return next;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }
}
