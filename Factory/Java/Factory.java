

class Factory {

	static class Animal {
		void call() {
			System.out.println("I have no distinct call..");
		}
	}

	enum AnimalType {
		DOG, CAT, OWL, SHEEP
	}

	static class Dog extends Animal {
		void call() {
			System.out.println("Woof!");
		}
	}

	static class Cat extends Animal {
		void call() {
			System.out.println("Meow!");
		}
	}

	static class Owl extends Animal {
		void call() {
			System.out.println("Bohoo!");
		}
	}

	static Animal animalFactory(AnimalType type) {
		switch (type) {
			case DOG:
				return new Dog();
			case CAT:
				return new Cat();
			case OWL:
				return new Owl();
			default:
				return new Animal();
		}
	}

	public static void main(String[] args) {
		animalFactory(AnimalType.DOG).call();
		animalFactory(AnimalType.CAT).call();
		animalFactory(AnimalType.OWL).call();
		animalFactory(AnimalType.SHEEP).call();
	}

}
