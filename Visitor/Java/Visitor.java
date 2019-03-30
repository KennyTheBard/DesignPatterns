abstract class Visitor {

	void visit(Entity e) {
		System.out.println("Not sure..");
	}

	abstract void visit(NPC npc);
	abstract void visit(Monster monster);
	abstract void visit(Player player);

	static abstract class Entity {
		abstract void accept(Visitor v);
	}

	static class NPC extends Entity {
		void accept(Visitor v) {
			v.visit(this);
		}
	}

	static class Monster extends Entity {
		void accept(Visitor v) {
			v.visit(this);
		}
	}

	static class Player extends Entity {
		void accept(Visitor v) {
			v.visit(this);
		}
	}

	static class Hunter extends Visitor {
		void visit(NPC npc) {
			System.out.println("Ignore");
		}

		void visit(Monster monster) {
			System.out.println("Attack");
		}

		void visit(Player player) {
			System.out.println("Give quest");
		}
	}

	static class Demon extends Visitor {
		void visit(NPC npc) {
			System.out.println("Attack");
		}

		void visit(Monster monster) {
			System.out.println("Scare");
		}

		void visit(Player player) {
			System.out.println("Attack");
		}
	}

	public static void main(String[] args) {
		Visitor hunter = new Hunter();
		Visitor demon = new Demon();

		Entity npc = new NPC();
		Entity monster = new Monster();
		Entity player = new Player();

		npc.accept(hunter);
		monster.accept(hunter);
		player.accept(hunter);

		npc.accept(demon);
		monster.accept(demon);
		player.accept(demon);
	}

}
