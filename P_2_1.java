import java.util.HashSet;

import myutil.LinkedListNode;

public class P_2_1 {
  public static void main(String[] args) {
    LinkedListNode head = new LinkedListNode(1);
    head.append(1)
        .append(2)
        .append(3)
        .append(2)
        .append(4)
        .append(3)
        .append(5)
        .append(10)
        .append(1)
        .append(10);
    
      deleteDups(head);
      while(head != null) {
        System.out.println(head.value);
        head = head.next;
      }
  }

  static void deleteDupsHashVersion(LinkedListNode node) {
    HashSet<Integer> set = new HashSet<>();

    LinkedListNode prev = null;
    while (node != null) {
      if (set.contains(node.value)) {
        prev.next = node.next;
      }
      else {
        set.add(node.value);
        prev = node;
      }
      node = node.next;
    } 
  }

  static void deleteDups(LinkedListNode node) {
    LinkedListNode current = node;
    
    while (current != null) {
      LinkedListNode prev = current;
      LinkedListNode runner = current.next;
      while (runner != null) {
        if (runner.value == current.value) {
          prev.next = runner.next;
        }
        else {
          prev = runner;
        }
        runner = runner.next;
      }
      current = current.next;
    }
  }  
}
