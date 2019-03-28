import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

class Bridge {

    private List<Integer> list;

    void setList(List<Integer> list) {
        this.list = list;
    }

    void addElement(Integer elem) {
        if (list != null)
            list.add(elem);
    }

    public static void main(String[] args) {
        List<Integer> link = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();

        Bridge b = new Bridge();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 1) {
                b.setList(arr);
            } else {
                b.setList(link);
            }

            b.addElement(i + 1);
        }

        System.out.println(link);
        System.out.println(arr);

    }

}
