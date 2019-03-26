import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

class ObjectPool {

	static class Displayer {

		private int display;

		Displayer() {
			this.display = 0;
		}

		void addDisplay(int value) {
			this.display = value;
		}

		void display() {
			System.out.print(display);
		}

	}

	Queue<Displayer> pool;
	List<Displayer> list;

	ObjectPool(int n) {
		int i;
		this.pool = new LinkedList<>();
		this.list = new LinkedList<>();

		for (i = 0; i < n; i++) {
			Displayer d = new Displayer();
			this.pool.add(d);
			this.list.add(d);
		}
	}

	void display() {
		for (Displayer d : this.list) {
			d.display();
			System.out.print(" ");
		}
		System.out.print("\n");
	}

	void addTask(int task) {
		Displayer d = this.pool.poll();
		d.addDisplay(task);
		this.pool.add(d);
	}

	public static void main(String[] args) {
		ObjectPool pool = new ObjectPool(5);
		int i;

		for (i = 1; i < 20; i ++) {
			pool.addTask(i);
			if (i % 2 == 0)
				pool.display();
		}
	}

}
