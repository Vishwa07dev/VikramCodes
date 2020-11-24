public class MyLinkedList {

  private ListNode head ;

  public MyLinkedList(ListNode head) {
    this.head = head;
  }

  //traversal

  public void traverse(ListNode head){
    if(head == null){
      return ;

    }

    ListNode temp  = head ;

    while(temp !=null){
      System.out.print(temp.getData() + " -> ");
      temp = temp.getNext();
    }
  }

  public int length(ListNode head){
    if(head == null){
      return 0;

    }
    ListNode temp  = head ;
    int length = 0 ;
    while(temp !=null){
      length++;
      temp = temp.getNext();
    }

    return length ;
  }

  /**
   *
   * @param head  -- indicates the LL
   * @param data  -- data to be inserted
   * @param k   -- index/position where data has to be inserted
   */
  public ListNode insert(ListNode head , int data , int k){

    //Write the code for adding node at first position
    /**
     *    k value should start from 1
     *   1-->2-->3--->4--->null
     *
     *   add 7 to the first position
     *
     *   7 -->1 -->2 -->3-->4 -->null   return  7 which is the new head
     *
     */

    if(k<=0 || k> length(head)+1){
      System.out.println("Invalid value of k passed : "+ k);
      return head ;
    }

    ListNode newNode = new ListNode(data);

    if(k==1){ // we need to add the element at the head
      newNode.setNext(head);
      head = newNode ;
    }else{

      /**
       *  1-->2-->3-->4-->5-->6-->null
       *
       *  Add 7 to 4th position
       *
       *  1. jump till 3
       *  2. set 4 next as 3 next
       *  3. set 3 next as 4 ?
       */

      ListNode temp = head ;

      int count =1 ;

      while(count < k){
        temp = temp.getNext();
        count++;
      }

        // this current the previous node of the place where new node has to be inserted

      newNode.setNext(temp.getNext());
      temp.setNext(newNode);

    }

    return head;

  }

}
