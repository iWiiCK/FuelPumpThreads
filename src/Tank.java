import java.util.Random;

public class Tank
{
    private int fuel = 0;
    private final int capacity;
    private final Random random = new Random();

    public Tank(int capacity) {
        this.capacity = capacity;
    }

    private int getRandNumBetween(int v1, int v2){
        return random.nextInt(v2-v1) + v1;
    }

    public synchronized void consume(int pumpId) throws InterruptedException {
        while(fuel == 0){
            System.out.println("[TANK IS EMPTY :: Pump " + pumpId +" WAITING]");
            wait();
        }
        //Consuming Random amount based on the remaining fuel
        int consumption = fuel > 1 ? getRandNumBetween(1,fuel): 1;
        fuel -= consumption;

        System.out.println("Pump " + pumpId + " consumed " + consumption + " Unit(s)");
        System.out.println("[Remaining Fuel:: " + fuel + "]\n");
        notifyAll();
    }

    public synchronized void fill(int amount) throws InterruptedException {
        double delay = 0.2;
        long endTime = (long) (System.currentTimeMillis() + (delay * 1000));

        while(fuel > 0){
            wait();
        }
        if(fuel == 0){
            System.out.println("\n===================================");
            System.out.println("REFUELING IN PROGRESS");
        }

        //Refill tank with a delay
        while (fuel < capacity){
            if(System.currentTimeMillis() > endTime){
                fuel += amount;
                System.out.println("[Fuel Level:: " + fuel + "]");
                endTime = (long) (System.currentTimeMillis() + delay * 1000);
            }
        }

        System.out.println("TANK FULL");
        System.out.println("===================================\n");
        notifyAll();
    }
}
