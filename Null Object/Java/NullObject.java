import java.util.List;
import java.util.LinkedList;

class NullObject {

	static int breads = 0;
	static int fishes = 0;

	static abstract class Worker {
		abstract void work();
	}

	static class LazyWorker extends Worker {
		void work() {
			// nothing
		}
	}

	static class Baker extends Worker {
		void work() {
			breads++;
		}
	}

	static class Fisherman extends Worker {
		void work() {
			fishes++;
		}
	}

	public static void main(String[] args) {
		List<Worker> workForce = new LinkedList<>();
		for (int i = 0; i <= 10; i++)
			if (i % 3 == 0)
				workForce.add(new LazyWorker());
			else if (i % 3 == 1)
				workForce.add(new Baker());
			else
				workForce.add(new Fisherman());

		for (Worker w : workForce)
			w.work();

		System.out.println("Breads : " + breads);
		System.out.println("fishes : " + fishes);

	}

}
