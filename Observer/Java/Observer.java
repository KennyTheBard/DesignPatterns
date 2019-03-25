class Observer {

	Observer() {}

	void update(int value) {
		System.out.println(value);
	}

	static class Subject {

		private int value;

		private Observer obs;

		Subject(Observer obs) {
			this.value = 0;
			this.obs = obs;
		}

		void setValue(int value) {
			this.value = value;
			obs.update(value);
		}

	}

	public static void main(String[] args) {

		Observer obs = new Observer();
		Observer.Subject sub = new Observer.Subject(obs);

		int i;
		for (i = 0; i < 10; i++)
			sub.setValue(i);

	}

}
