class Decorator {

	private Dog dog;

	Decorator(Dog dog) {
		this.dog = dog;
	}

	String call() {
		return ">> " + dog.call();
	}

	static class Dog {
		String call() {
			return "Woof!";
		}
	}

	public static void main(String[] args) {
		Decorator d = new Decorator(new Dog());
		System.out.println(d.call());
	}

}
