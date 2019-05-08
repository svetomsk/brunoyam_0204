public class ClassesTest {

    String name;

    public static void main(String[] args) {
        int [] a = new int[10];
        Car car = new Car();
        System.out.println(car.engineType);
        System.out.println(car.maxSpeed);
        System.out.println(car.numberOfDoors);
        car.maxSpeed = 150;
        car.numberOfDoors = 4;
        System.out.println(car.engineType);
        System.out.println(car.maxSpeed);
        System.out.println(car.numberOfDoors);

        Car anotherCar = new Car();
        anotherCar.maxSpeed = 200;
        anotherCar.numberOfDoors = 5;

        Car carWithConstructor = new Car("Third type", 150, 4, 5, 6);
    }

    public static void printCarInformation(Car car) {
        System.out.println(car.engineType + " " + car.maxSpeed + " " +
                car.numberOfDoors + " " + car.oilType + " " + car.numberOfDoors);
    }

    public static void printCarInformation(String a, int b, int c, int d, int e) {
        System.out.println(a + " " + b + " " + c + " " + d + " " + e);
    }


}
