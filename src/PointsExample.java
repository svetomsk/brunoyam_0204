public class PointsExample {
    static double[] x;
    static double[] y;
    static double[] z;
    static double[] color;
    static int pointsCount = 0;

    public static void main(String[] args) {
        PointsStorage1 storage = new PointsStorage1();
        CustomPoint1 p1 = new CustomPoint1(1, 1, 1, 1);
        storage.addPoint(p1);
        storage.addPoint(new CustomPoint1(2, 1, 1, 1));
        storage.addPoint(new CustomPoint1(3, 1, 1, 1));
        storage.printPoints();
//        p1.setZ(0);
        System.out.println(storage.calculateBadValue(0));

        Robott robot = new Robott(0, 0, Directions.UP);

//        x = new double[100];
//        y = new double[100];
//        z = new double[100];
//        color = new double[100];
//
//        addPoint(1, 1, 1, 1);
//        addPoint(2, 1, 1, 1);
//        addPoint(3, 1, 1, 1);
//
//        printPoints();

    }

    static void addPoint(double xx, double yy, double zz, double colorr) {
        x[pointsCount] = xx;
        y[pointsCount] = yy;
        z[pointsCount] = zz;
        color[pointsCount] = colorr;
        pointsCount++;
    }

    static void printPoints() {
        for (int i = 0; i < pointsCount; i++) {
            System.out.println(x[i] + " " + y[i] + " " + z[i] + " " + color[i]);
        }
    }

}
