import java.util.List;
import java.util.LinkedList;

class Proxy {

	private List<Integer> list;
	private int secretCode;

	Proxy() {
		this.list = new LinkedList<>();
		this.secretCode = 101;
	}

	boolean add(Integer i) {
		list.add(i);

		return true;
	}

	boolean remove(int code, Integer i) {
		if (code != secretCode)
			return false;

		list.remove(i);
		return true;
	}

	boolean display(int code) {
		if (code != secretCode)
			return false;

		for (Integer i : list)
			System.out.print(i + " ");
		System.out.println();
		return true;
	}

	static void attempt(boolean ret) {
		if (!ret)
			System.out.println("ACCESS DENIED!");
	}

	public static void main(String[] args) {
		Proxy p = new Proxy();

		p.add(1);
		p.add(2);
		p.add(3);

		attempt(p.display(20));
		attempt(p.display(101));

		attempt(p.remove(20, 2));
		attempt(p.remove(101, 2));

		attempt(p.display(101));
	}

}
