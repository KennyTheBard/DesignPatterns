import java.util.List;
import java.util.LinkedList;

class Composite {

	static class Component {

		List<Component> children;

		Component() {
			children = new LinkedList<Component>();
		}

		void addComponent(Component c) {
			children.add(c);
		}

		long count() {
			long count = 0;

			for (Component c : children)
				count += c.count();

			return 1 + count;
		}
	}

	public static void main(String[] args) {
		Component c1 = new Component();
		c1.addComponent(new Component());
		c1.addComponent(new Component());

		Component c2 = new Component();
		c2.addComponent(new Component());
		c2.addComponent(new Component());
		c2.addComponent(new Component());

		Component c = new Component();
		c.addComponent(c1);
		c.addComponent(c2);

		System.out.println(c.count());
	}

}
