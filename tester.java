public class tester {
  public static void main(String[] args) {
    MyLinkedList words = new MyLinkedList();
    //add 0-9 in order
    for(int i = 0; i < 10; i++){
      words.add(i+"");
    }
    //insert 0x - 9x before each value 0-9
    for(int i = 0; i < 10; i++){
      words.add(2*i,i+"x");
    }
    //check the head/tail add
    words.add(0,"head");
    words.add(words.size(),"tail");

    System.out.println(words.toString().equals("[head, 0x, 0, 1x, 1, 2x, 2, 3x, 3, 4x, 4, 5x, 5, 6x, 6, 7x, 7, 8x, 8, 9x, 9, tail]"));
    System.out.println(words.toStringReversed().equals("[tail, 9, 9x, 8, 8x, 7, 7x, 6, 6x, 5, 5x, 4, 4x, 3, 3x, 2, 2x, 1, 1x, 0, 0x, head]"));

    try{
      words.add(-1,"");
      System.out.println("ERROR! Added to negative index");
    }catch(IndexOutOfBoundsException e){
    }

    try{
      words.add(words.size()+1,"");
      System.out.println("ERROR! Added to (size + 1) index");
    }catch(IndexOutOfBoundsException e){
    }

    try{
      words.remove(-1);
      System.out.println("ERROR! Removed to negative index");
    }catch(IndexOutOfBoundsException e){
    }

    try{
      words.remove(words.size());
      System.out.println("ERROR! Removed to size index");
    }catch(IndexOutOfBoundsException e){
    }

    System.out.println();
    MyLinkedList t = new MyLinkedList();
    t.add("hey");
    t.add("Wassup");
    t.add("cat");
    t.add("dog");
    System.out.println(t);
    int index = 2;
    System.out.println(t.get(index)+" is index "+index);
    t.add(2, "ADD");
    System.out.println(t);
    System.out.println(t.set(3, "SET")+" was replaced");
    System.out.println(t);
    System.out.println();
    System.out.println();


    //Part 2 Testing
    System.out.println("PART 2");
    MyLinkedList r = new MyLinkedList();
    for(int i = 10; i < 20; i++){
      r.add(i+"");
    }
    System.out.println(r);
    int gone = r.size() - 1;  //index to remove
    System.out.println(r.remove(gone)+" at index "+gone+" will be removed");
    System.out.println(r);

    System.out.println("EXTEND");
    MyLinkedList empty = new MyLinkedList();
    MyLinkedList other = r;
    // MyLinkedList other = r;
    t.extend(other);
    System.out.println(t);
    String work = "";
    if (other.toString().equals("[]")) {
      work = "YAY IT'S EMPTY";
    } else {
      work = "WRONGG";
    }
    String workSize = "";
    if (t.size() == t.size() + other.size()) {
      workSize = " YAY RIGHT SIZE";
    } else {
      workSize = " WRONGG";
    }
    System.out.println(work + workSize);
    System.out.println();

    System.out.println("Mr K extends");
    MyLinkedList a = new MyLinkedList();
    MyLinkedList b = new MyLinkedList();
    for(int i = 0; i < 10; i++){
      if(i < 5){
        a.add(i+"");
      }else{
        b.add(i+"");
      }
    }
    System.out.println();
    System.out.println("A:"+a+a.size());
    System.out.println("B:"+b+b.size());

    a.extend(b);
    System.out.println("A:"+a+a.size());
    System.out.println("B:"+b+b.size());
    System.out.println("A reversed:"+a.toStringReversed()+a.size());
    System.out.println("B reversed:"+b.toStringReversed()+b.size());

    System.out.println();
    MyLinkedList c = new MyLinkedList();
    System.out.println();
    System.out.println("C:"+c+c.size());
    System.out.println("A:"+a+a.size());

    c.extend(a);
    System.out.println("C:"+c+c.size());
    System.out.println("A:"+a+a.size());
    System.out.println("C reversed:"+c.toStringReversed()+c.size());
    System.out.println("A reversed:"+a.toStringReversed()+a.size());
  }
}
