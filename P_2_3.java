import myutil.LinkedListNode;

public class P_2_3 {
  
  static boolean deleteNode(LinkedListNode node) {
    if(node == null || node.next == null) {
      return false;
    }

    LinkedListNode next = node.next;
    node.value = next.value;
    node.next = next.next;
    return true;
  }
}
