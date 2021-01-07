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

    if (index == size - 1) {
      add(value);
    }

    Node ans = new Node(value);
    if (index == 0) {
      //have to set prev and next first or else I lose start
      start.setPrev(ans);
      ans.setNext(start);
      start = ans;
    }
    size++;
  }

  public String get(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Index " + index + " cannot be out of range of MyLinkedList");
    }
    return findNode(index).getData();
  }

  // public String set(int index, String value) {
  //   if (index < 0 || index >= size()) {
  //     throw new IndexOutOfBoundsException("Index " + index + " cannot be out of range of MyLinkedList");
  //   }
  // }

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

}
