

class Singleton {

	private static Singleton INSTANCE = null;

	private Singleton() {}

	public static Singleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Singleton();
		}

		return INSTANCE;
	}

	public static void main(String[] args) {

		Singleton s = Singleton.getInstance();

		assert s == Singleton.getInstance() : "Broken Singleton!";

	}
}
