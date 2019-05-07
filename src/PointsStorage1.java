import java.util.ArrayList;
import java.util.List;

public class PointsStorage1 {
    private List<CustomPoint1> points;

    public PointsStorage1() {
        points = new ArrayList<>();
    }

    public void addPoint(CustomPoint1 point) {
        points.add(point);
    }

    public void printPoints() {
        for(CustomPoint1 point : points) {
            System.out.println(point.getX() + " " + point.getY() + " " + point.getZ() +
            " " + point.getColor());
        }
    }

    public double calculateBadValue(int index) {
        CustomPoint1 current = points.get(index);
        return (current.getX() + current.getY()) / current.getZ();
    }
}
