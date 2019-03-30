import java.util.List;
import java.util.LinkedList;

class Flyweight {

	static Armyman soldier;
	static Armyman commander;
	static int objectsCreated = 0;

	static abstract class Armyman {
		abstract void fight();
	}

	static class Soldier extends Armyman {

		Soldier() {
			objectsCreated++;
		}

		void fight() {
			System.out.println("Pew pew!");
		}
	}

	static class Commander extends Armyman {

		Commander() {
			objectsCreated++;
		}

		void fight() {
			System.out.println("Do that!");
		}
	}

	static Armyman getArmyman(boolean ranked) {
		if (ranked) {
			if (commander == null)
				commander = new Commander();
			return commander;
		} else {
			if (soldier == null)
				soldier = new Soldier();
			return soldier;
		}
	}

	public static void main(String[] args) {
		List<Armyman> army = new LinkedList<>();

		for (int i = 0; i < 10; i ++)
			if (i % 4 == 0)
				army.add(getArmyman(true));
			else
				army.add(getArmyman(false));

		System.out.println("Objects created: " + objectsCreated);

		for (Armyman a : army)
			a.fight();
	}

}
