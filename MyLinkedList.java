public class MyLinkedList {
  private int size;
  private Node start, end;

  public MyLinkedList() {
    size = 0;
  }

  public int size() {
    return size;
  }

  private Node findNode(int index) {
    Node ans = start;
    for (int i = 0; i < index; i++) {
      ans = ans.getNext();
    }
    return ans;
  }

  public boolean add(String value) {
    Node ans = new Node(value);
    if (size == 0) {
      start = ans;
      end = ans;
    } else {
      //have to set prev and next first or else I lose end
      ans.setPrev(end);
      end.setNext(ans);
      end = ans;
    }
    size++;
    return true;
  }

  public void add(int index, String value) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("Index " + index + " cannot exceed the size of MyLinkedList");
    }

    Node ans = new Node(value);
    if (size == 0) {  //EMPTY list
      start = ans;
      end = ans;
    } else if (index == size) {  //TAIL node
      ans.setPrev(end);
      end.setNext(ans);
      end = ans;
    } else if (index == 0) {  //HEAD node
      //have to set prev and next first or else I lose start
      start.setPrev(ans);
      ans.setNext(start);
      start = ans;
    } else {  //All other nodes (middle node)
      Node next = findNode(index);
      Node prev = next.getPrev();
      ans.setPrev(prev);
      next.setPrev(ans);
      ans.setNext(next);
      prev.setNext(ans);  //nodes in front AND back of middle node are affected
    }
    size++;
  }

  public String get(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Index " + index + " cannot be out of range of MyLinkedList");
    }
    return findNode(index).getData();
  }

  public String set(int index, String value) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Index " + index + " cannot be out of range of MyLinkedList");
    }
    Node replace = findNode(index);
    String old = replace.getData();
    replace.setData(value);
    return old;
  }

  public String toString() {
    if (size == 0) return "[]";

    Node current = start;
    String display = "[";
    while (current != null) {
      display += current.getData();
      if (current.getNext() != null) {
        display += ", ";
      } else {
        display +=  "]";
      }
      current = current.getNext();
    }
    return display;
  }
  public String toStringReversed() {
    if (size == 0) return "[]";

    Node current = end;
    String display = "[";
    while (current != null) {
      display += current.getData();
      if (current.getPrev() != null) {
        display += ", ";
      } else {
        display +=  "]";
      }
      current = current.getPrev();
    }
    return display;
  }

  public String remove(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Index " + index + " cannot be out of range of MyLinkedList");
    }

    Node ans = findNode(index);
    String removed = ans.getData();
    if (size == 1) {   //removing the FINAL element of a list
      start = null;
      end = null;
    } else if (index == 0) {   //removing the HEAD
      Node newStart = start.getNext();
      newStart.setPrev(null);
      start = newStart;
    } else if (index == size - 1) {   //removing the TAIL
      Node newEnd = end.getPrev();
      newEnd.setNext(null);
      end = newEnd;
    } else {   //removing from the MIDDLE
      Node next = ans.getNext();
      Node prev = ans.getPrev();
      next.setPrev(prev);
      prev.setNext(next);
    }
    size--;
    return removed;
  }

  /*
  *@postcondition: All of the elements from other are removed from the other, and connected to the end of this linked list.
  *@postcondition: The size of other is reduced to 0.
  *@postcondition: The size of this is now the combined sizes of both original lists
  */
  public void extend(MyLinkedList other) {
    if (size == 0 && other.size == 1) {
      start = other.start;
      end = other.end;
    } else if (size == 0) {
      start = other.start;
      start.setNext(other.start);
      other.start.setPrev(start);
      end = other.end;
    } else {
      end.setNext(other.start);
      other.start.setPrev(end);
      end = other.end;
    }
    size += other.size;
    other.start = null;  //confused about why you can't use setData
    other.end = null;
    other.size = 0;
  }

}
