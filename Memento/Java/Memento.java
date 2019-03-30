class Memento {

	static class State {
		public String name;
		public int age;
	}

	private int id;
	private State state;

	Memento(int id) {
		this.id = id;
		this.state = new State();
		state.name = "<default>";
		state.age = -1;
	}

	void salute() {
		System.out.println("[" + id + "]Hello, I'm " + state.name + " and i am " + state.age + " years old!");
	}

	void setState(State state) {
		this.state = state;
	}

	State getState() {
		return state;
	}

	void setName(String name) {
		state.name = name;
	}

	String getName() {
		return state.name;
	}

	void setAge(int age) {
		state.age = age;
	}

	int getAge() {
		return state.age;
	}

	public static void main(String[] args) {
		Memento m1 = new Memento(1);
		Memento m2 = new Memento(2);

		m1.salute();
		m2.setName("Angello");
		m2.setAge(21);
		m2.salute();
		m1.setState(m2.getState());
		m1.salute();
	}

}
