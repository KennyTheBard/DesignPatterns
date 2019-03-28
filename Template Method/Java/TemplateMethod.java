import java.util.List;
import java.util.ArrayList;

class TemplateMethod {

    static abstract class Sort {
        protected List<Integer> list;

        void setup(List<Integer> list) {
            this.list = list;
        }

        abstract void sort();

        void display() {
            for (Integer i : this.list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static class BubbleSort extends Sort {

        void sort() {
            int i, j, aux;

            for (i = 0; i < list.size(); i++) {
                for (j = i + 1; j < list.size(); j++) {
                    if (list.get(i) > list.get(j)) {
                        aux = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, aux);
                    }
                }
            }
        }
    }

    static public void main(String[] args) {
        Sort s = new BubbleSort();
        List<Integer> list = new ArrayList<>();

        int i;
        for (i = 0; i < 10; i ++) {
            list.add((i + 1) * 893 % 10);
        }

        s.setup(list);
        s.display();
        s.sort();
        s.display();
    }

}
