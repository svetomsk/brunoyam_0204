public class CustomPoint1 {
    private double x;
    private double y;
    private double z;
    private double color;

    public CustomPoint1(double x, double y, double z, double color) {
        if(z == 0) {
            throw new IllegalArgumentException("z must not be zero");
        }
        this.x = x;
        this.y = y;
        this.z = z;
        this.color = color;
    }


    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        if(z == 0) {
            throw new IllegalArgumentException("z must not be zero");
        }
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getColor() {
        return color;
    }

    public void setColor(double color) {
        this.color = color;
    }
}
