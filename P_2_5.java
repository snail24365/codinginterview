import myutil.LinkedListNode;

public class P_2_5 {
  public static void main(String[] args) {
    LinkedListNode n1 = new LinkedListNode(0);
    n1.append(5);
    
    LinkedListNode n2 = new LinkedListNode(0);
    n2.append(5);
                                          //.append(1);
    System.out.println(addArithmatic(n1, n2));
  }

  static LinkedListNode addArithmatic(LinkedListNode n1, LinkedListNode n2) {
    LinkedListNode head = null;
    LinkedListNode runner = null;
    int carry = 0;
    while(n1 != null || n2 != null) {
      int val1 = n1 == null ? 0 : n1.value;
      int val2 = n2 == null ? 0 : n2.value;
      LinkedListNode node = new LinkedListNode((val1+val2+carry)%10);
      carry = (val1+val2+carry)/10;
      
      if (head == null) {
        head = node;
        runner = node;
      }
      else {
        runner.next = node;
        runner = runner.next;
      }
      if (n1 != null) {
       n1 = n1.next;
      }
      if (n2 != null){ 
        n2 = n2.next;
      }
    }
    if (carry > 0) {
      runner.next = new LinkedListNode(carry);
    }
    return head;
  }

  static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
    if(l1 == null && l2 == null && carry == 0) {
      return null;
    }

    LinkedListNode result = new LinkedListNode();
    int value = carry;
    if (l1 != null) {
      value += l1.value;
    }
    if (l2 != null) {
      value += l2.value;
    }

    result.value = value % 10;

    if (l1!= null || l2 != null) {
      LinkedListNode more = addLists(l1 == null ? null : l1.next,
                                     l2 == null ? null : l2.next,
                                     value >= 10 ? 1 :0);
      result.next = more;
    }
    return result;
  }
}
