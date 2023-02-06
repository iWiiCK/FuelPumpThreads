public class Main
{
    public static void main(String[] args) throws InterruptedException {
        //Fuel Tank
        Tank tank = new Tank(10);

        //Fuel Pumps
        Pump p1 = new Pump(1, tank, 1);
        Pump p2 = new Pump(2, tank, 3);

        //Fuel Dispenser for Refueling
        FuelDispenser dispenser = new FuelDispenser(tank, 1);

        Thread p1Thread = new Thread(p1);
        Thread p2Thread = new Thread(p2);
        Thread dispenserThread = new Thread(dispenser);

        System.out.println("\n *** STARTING SIMULATION *** \n");

        p1Thread.start();
        p2Thread.start();
        dispenserThread.start();

        p1Thread.join();
        p2Thread.join();
        dispenserThread.join();
    }
}
