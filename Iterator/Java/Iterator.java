import java.util.List;
import java.util.LinkedList;

class Iterator<T> {

  private List<T> list;
  private int index;

  Iterator(List<T> list) {
    this.list = list;
    index = 0;
  }

  boolean hasNext() {
    return index < list.size();
  }

  T next() {
    return list.get(index++);
  }

  void remove() throws IllegalStateException {
    if (index == 0) throw new IllegalStateException();

    list.remove(--index);
  }

  public static void main(String[] args) {
    List<Integer> list = new LinkedList<>();
    int i;

    for (i = 0; i < 10; i++) {
      list.add(i);
    }

    Iterator<Integer> it = new Iterator<>(list);

    while (it.hasNext()) {
      if (it.next() % 2 == 0) {
        it.remove();
      }
    }

    for (i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }

}
