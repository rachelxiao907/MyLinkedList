public class tester {
  public static void main(String[] args) {
    MyLinkedList t = new MyLinkedList();
    t.add("hey");
    t.add("Wassup");
    t.add("cat");
    t.add("dog");
    System.out.println(t);
    System.out.println(t.size());
    System.out.println(t.get(1));
    t.add(1, "ADD");
    System.out.println(t);
    System.out.println(t.size());
    System.out.println(t.set(3, "SET"));
    System.out.println(t);
  }
}
