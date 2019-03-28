class Adapter {

    static final int FIELD = 0;
    static final int FORREST = 1;
    static final int RIVER = 2;
    static final int STONE = 3;
    static final int CROP = 4;

    static class Tile {

        int value;

        Tile(int value) {
            this.value = value;
        }
    }

    static class Worker {

        void cut(Tile t) {
            t.value += -1;
        }

        void drain(Tile t) {
            t.value += -2;
        }

        void mine(Tile t) {
            t.value += -3;
        }

        void plant(Tile t) {
            t.value += 4;
        }

    }

    private Worker slave;

    Adapter(Worker slave) {
        this.slave = slave;
    }

    void clean(Tile t) {
        switch (t.value) {
            case FORREST:
                slave.cut(t);
                return;
            case RIVER:
                slave.drain(t);
                return;
            case STONE:
                slave.mine(t);
                return;
            default:
                return;
        }
    }

    void plant(Tile t) {
        clean(t);
        if (t.value != CROP)
            slave.plant(t);
    }

    public static void main(String[] args) {
        Adapter master = new Adapter(new Worker());

        Tile t;

        t = new Tile(RIVER);
        master.plant(t);
        System.out.println(t.value);

        t = new Tile(STONE);
        master.clean(t);
        System.out.println(t.value);

        t = new Tile(CROP);
        master.plant(t);
        System.out.println(t.value);
    }
}
