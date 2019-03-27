class Strategy {

	static interface IStrategy {
		int calculate(int i);
	}

	static class Strategy1 implements IStrategy {
		public int calculate(int i) {
			return i * i;
		}
	}

	static class Strategy2 implements IStrategy {
		public int calculate(int i) {
			return i % 10;
		}
	}

	public static void main(String[] args) {
		IStrategy s1 = new Strategy1();
		IStrategy s2 = new Strategy2();
		int i = 25;

		System.out.println(s1.calculate(i));
		System.out.println(s2.calculate(i));
	}

}
