
class Command {

	private boolean eat;
	private boolean drink;
	private boolean sleep;

	Command(boolean eat, boolean drink, boolean sleep) {
		this.eat = eat;
		this.drink = drink;
		this.sleep = sleep;
	}

	boolean shouldEat() {
		return this.eat;
	}

	boolean shouldDrink() {
		return this.drink;
	}

	boolean shouldSleep() {
		return this.sleep;
	}

	static class Robot {

		void execute(Command cmd) {
			if (cmd.shouldEat()) {
				eat();
			}

			if (cmd.shouldDrink()) {
				drink();
			}

			if (cmd.shouldSleep()) {
				sleep();
			}
		}

		void eat() {
			System.out.println("Is eating..");
		}

		void drink() {
			System.out.println("Is drinking..");
		}

		void sleep() {
			System.out.println("Is sleeping..");
		}
	}

	public static void main(String[] args) {

		Robot r = new Robot();

	 	r.execute(new Command(true, false, false));
		r.execute(new Command(true, false, true));
		r.execute(new Command(true, true, true));

	}

}
