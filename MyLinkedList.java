public class MyLinkedList {
  private int size;
  private Node start, end;

  public MyLinkedList() {
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean add(String value) {
    Node ans = new Node(value);
    if (size == 0) {
      start = ans;
      end = ans;
    } else {
      ans.setPrev(end);
      end.setNext(ans);
      end = ans;
    }
    size++;
    return true;
  }

}
