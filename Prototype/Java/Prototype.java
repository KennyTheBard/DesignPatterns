
class Prototype {

	private static int total = 0;
	private int id;
	private int value;

	Prototype(int value) {
		this.id = total++;
		this.value = value;
	}

	void display() {
		System.out.println(value);
	}

	public Prototype clone() {
		return new Prototype(this.value);
	}

	public static void main(String[] args) {
		Prototype p1 = new Prototype(1);
		Prototype p2 = new Prototype(2);

		p1.display();
		p1.clone().display();
		p2.display();
	}

}
