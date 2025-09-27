package Practice.src.designpattern.strategy.ex1;

public class RideFareCalculationDemo {

    public static void main(String[] args) {

        Ride miniRide = new MiniRide();
        System.out.println("Mini Ride Fare: " + miniRide.calculateRideFare());

        Ride sedanRide = new SedanRide();
        System.out.println("Sedan Ride Fare: " + sedanRide.calculateRideFare());

        Ride suvRide = new SuvRide();
        System.out.println("Suv Ride Fare: " + suvRide.calculateRideFare());

        Ride luxuryRide = new LuxuryRide();
        System.out.println("Luxury Ride Fare: " + luxuryRide.calculateRideFare());
    }
}
