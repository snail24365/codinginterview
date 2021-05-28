import myutil.LinkedListNode;

public  class P_2_4 {

  public static void main(String[] args) {
    LinkedListNode head = new LinkedListNode(1);
    head.append(10)
        .append(4)
        .append(8)
        .append(5)
        .append(6)
        .append(3)
        .append(2)
        .append(20)
        .append(400)
        .append(-1);
    LinkedListNode ret = partitionByX(head, 5);
    System.out.println(ret);
  }

  static LinkedListNode partitionByX(LinkedListNode node, int x) {
    LinkedListNode leftGroupHead = null;
    LinkedListNode leftGroup = null;
    LinkedListNode rightGroupHead = null;
    LinkedListNode rightGroup = null;

    while (node != null) {
      if(node.value < x) {
        if(leftGroupHead == null) {
          leftGroupHead = node;
          leftGroup = node;
        }
        else {
          leftGroup.next = node;
          leftGroup = node;
        }
      }
      else {
        if(rightGroupHead == null) {
          rightGroupHead = node;
          rightGroup = node;
        }
        else {
          rightGroup.next = node;
          rightGroup = node;
        }
      }
      node = node.next;
    }
    rightGroup.next = null;
    leftGroup.next = rightGroupHead;
    return leftGroupHead;
  }

  static LinkedListNode partition(LinkedListNode node, int x) {
    LinkedListNode head = node;
    LinkedListNode tail = node;

    while (node != null) {
      LinkedListNode next = node.next;
      if(node.value < x) {
        node.next = head;
        head = node;
      } else {
        tail.next = node;
        tail = node;
      }
      node = next;
    }
    tail.next = null;
    return head;
  }
}
