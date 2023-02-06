public class FuelDispenser implements Runnable
{
    private final int amount;
    private final Tank tank;

    public FuelDispenser(Tank tank, int amount) {
        this.tank = tank;
        this.amount = amount;
    }

    @Override
    public void run() {
        while(true){
            try {
                tank.fill(amount);
                //Refueling after 5 seconds
                Thread.sleep( 1000 * 5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
