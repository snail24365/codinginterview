import myutil.LinkedListNode;

public class P_2_6 {

  public static void main(String[] args) {
    LinkedListNode head = new LinkedListNode(1);
    head.append(2)
        .append(2)
        .append(1);
    System.out.println(isPalindrome(head)); 
  }

  static boolean isPalindrome(LinkedListNode node) {
    int n = 0;
    LinkedListNode runner = node;
    LinkedListNode reversed = null;
    while(runner != null) {
      n++;
      if (reversed == null) {
        reversed = new LinkedListNode(runner.value);
      }
      else {
        LinkedListNode newNode = new LinkedListNode(runner.value);
        newNode.next = reversed;
        reversed = newNode;
      }
      runner = runner.next;
    }

    for(int i = 0; i < n/2; i++) {
      if(reversed.value != node.value) {
        return false;
      }
      node = node.next;
      reversed = reversed.next;
    }
    return true;
  }
  
}
