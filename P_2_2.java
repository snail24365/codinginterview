import myutil.LinkedListNode;

public class P_2_2 {
  public static void main(String[] args) {
    LinkedListNode head = new LinkedListNode(1);
    head.append(2)
        .append(3)
        .append(4)
        .append(5)
        .append(6)
        .append(7)
        .append(8)
        .append(9)
        .append(10);
    System.out.println(kthFromBack(head, 1).value);
    System.out.println(kthFromBack(head, 2).value);
    System.out.println(kthFromBack(head, 3).value);
    System.out.println(kthFromBack(head, 10).value);
    System.out.println(kthFromBack(head, 0));
    System.out.println(kthFromBack(head, 11));

  }

  static LinkedListNode kthFromBack(LinkedListNode node, int k) {
    if(node == null || k < 1) {
      return null;
    }
    
    LinkedListNode runner = node;
    LinkedListNode kth = node;
    while(runner != null && k > 1) {
      runner = runner.next;
      k--;
    }

    if (runner == null || k > 1) {
      return null;
    }

    while(runner.next != null) {
      runner = runner.next;
      kth = kth.next;
    }
    return kth;
  } 

  static int printKthToLast(LinkedListNode head, int k) {
    if (head == null) {
      return 0;
    }
    int index = printKthToLast(head.next, k) + 1;
    if(index == k) {
      System.out.println(k + "th to last node is " + head.value);
    }
    return index;
  }

  class Index {
    public int value = 0;
  }
  LinkedListNode kthToLast(LinkedListNode head, int k) {
    Index idx = new Index();
    return kthToLast(head, k, idx);
  }
  
  LinkedListNode kthToLast(LinkedListNode head, int k, Index idx) {
    if (head == null) {
      return null;
    }
    LinkedListNode node = kthToLast(head.next, k, idx);
    idx.value = idx.value + 1;
    if (idx.value == k) {
      return head;
    }
    return node;
  }
}
