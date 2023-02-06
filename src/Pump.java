public class Pump implements Runnable{
    private final int id;
    private final Tank tank;

    private final int delay;

    public Pump(int id, Tank tank, int delay) {
        this.id = id;
        this.tank = tank;
        this.delay = delay;
    }

    @Override
    public void run() {
        while (true){
            try {
                tank.consume(id);
                Thread.sleep(delay * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
