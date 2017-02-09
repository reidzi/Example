/**
 * Created by v.grebnev on 06.02.2017.
 */


class Vehicle implements IVehicle {
    private int passengers; // number of passengers
    private int fuelcap;    // fuel capacity in gallons
    private int mpg;        // fuel consumption in miles per gallon

    // This is a constructor for Vehicle.
    Vehicle(int p, int f, int m) {
        passengers = p;
        fuelcap = f;
        mpg = m;
    }

    // Return the range.
    public int range() {
        return mpg * fuelcap;
    }

    // Compute fuel needed for a given distance.
    double fuelneeded(int miles) {
        return (double) miles / mpg;
    }

    int getPassengers() {return passengers;}
    void setPassengers(int i) {passengers = i;}
    int getFuelcap() {return fuelcap;}
    void setFuelcap(int i) {fuelcap = i;}
    int getMpg() {return mpg; }
    void setMpg(int i) {mpg = i;}

}

class Truck extends Vehicle {
    private int cargocap;
    Truck(int p, int f, int m, int c){
        super(p, f, m);
        cargocap = c;
    }
    int getCargo() {return cargocap;}
    void putCargo(int c) {cargocap = c;}


}

public class TruckDemo {
    public static void main(String args[]){

        Truck semi = new Truck(2, 200, 7, 44000);
        Truck pickup = new Truck(3, 28, 15, 2000);


        double gallons;
        int dist = 252;

        gallons = semi.fuelneeded(dist);
        System.out.println("Грузовик может перевезти " + semi.getCargo() + " фунтов.");
        System.out.println("Для преодоления " + dist + " миль грузовику требуется " + gallons + " галлонов топлива.\n");

        gallons = pickup.fuelneeded(dist);
        System.out.println("Пикап может перевезти " + pickup.getCargo() + " фунтов.");
        System.out.println("Для преодоления " + dist + " миль пикапу требуется " + gallons + " галлонов топлива.\n");

        if (semi.equals(pickup )) {
            System.out.println ("Одинаковые");
        } else {
            System.out.println("Разные");
        }






/*

        Vehicle minivan = new Vehicle(7, 16, 21);
                Vehicle sportscar = new Vehicle(2, 14, 12);



                gallons = minivan.fuelneeded(dist);



                gallons = sportscar.fuelneeded(dist);

                System.out.println("To go " + dist + " miles sportscar needs " +
                        gallons + " gallons of fuel.");
*/

    }
}
