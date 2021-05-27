package myutil;

public class LinkedListNode {
  public int value;
  public LinkedListNode next;

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
}