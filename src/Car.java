public class Car {
    String engineType;
    int maxSpeed;
    int numberOfDoors;
    int oilType;
    int numberOfPassangers;

    /**
     * Class constructor
     */
    public Car() {
        engineType = "First type";
    }

    /**
     * Class constructor with parameters
     */
    public Car(String engineType, int speed, int numberOfDoors, int oilType,
               int numberOfPassangers) {
        this.engineType = engineType;
        maxSpeed = speed;
        this.numberOfDoors = numberOfDoors;
        this.oilType = oilType;
        this.numberOfPassangers = numberOfPassangers;
    }
}

