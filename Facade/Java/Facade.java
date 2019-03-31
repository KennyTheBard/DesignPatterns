import java.util.Map;
import java.util.HashMap;

class Facade {

	private Map<Integer, String> nameMap;

	Facade() {
		this.nameMap = new HashMap<>();
	}

	void add(String name) {
		nameMap.put(name.hashCode(), name);
	}

	void display() {
		for (Map.Entry<Integer, String> entry : nameMap.entrySet())
			System.out.println(entry.getKey() + " : " + entry.getValue());
	}

	public static void main(String[] args) {
		Facade facade = new Facade();

		facade.add("one");
		facade.add("two");
		facade.add("three");

		facade.display();
	}

}
