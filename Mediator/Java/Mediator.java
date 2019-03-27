import java.util.HashMap;
import java.util.Map;

class Mediator {

	static final int BROADCAST = 0;
	private Map<Integer, User> network;

	Mediator() {
		network = new HashMap<>();
	}

	void logIn(User user) {
		network.put(user.getId(), user);
		user.setServer(this);
	}

	void sendMessage(int target, String message) {
		if (target == BROADCAST) {
			for (Map.Entry<Integer, User> entry : network.entrySet()) {
				entry.getValue().receive(message);
			}
			return;
		}

		network.get(target).receive(message);
	}

	static class User {

		private int id;
		private Mediator server;

		User(int id) {
			this.id = id;
		}

		void send(int target, String message) {
			server.sendMessage(target, message + " from " + this.id);
		}

		void receive(String message) {
			System.out.println(message + " to " + this.id);
		}

		int getId() {
			return this.id;
		}

		void setServer(Mediator server) {
			this.server = server;
		}

	}

	public static void main(String[] args) {
		Mediator m = new Mediator();

		User u1 = new User(1);
		User u2 = new User(2);
		User u3 = new User(3);

		m.logIn(u1);
		m.logIn(u2);
		m.logIn(u3);

		u3.send(1, "msg1");
		u2.send(3, "msg2");
		u1.send(BROADCAST, "brdcst");

	}

}
