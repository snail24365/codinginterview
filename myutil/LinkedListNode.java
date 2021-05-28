package myutil;

public class LinkedListNode {
  public int value;
  public LinkedListNode next;

  public LinkedListNode() {}

  public LinkedListNode(int value) {
    this.value = value;
  }
  public LinkedListNode(int value, LinkedListNode next) {
    this.value = value;
    this.next = next;
  }
  
  public LinkedListNode append(int value) {
    this.next = new LinkedListNode(value);
    return this.next;
  }

  @Override
  public String toString() {
    LinkedListNode runner = this;
    StringBuilder sb = new StringBuilder();
    while(runner != null) {
      sb.append(runner.value + ", ");
      runner = runner.next;
    }
    return sb.toString();
  }
}