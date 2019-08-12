package project;

public class Ship {
    private int x;
    private int y;
    private int size;
    private boolean isHorizontal;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public void setHorizontal(boolean horizontal) {
        isHorizontal = horizontal;
    }


    public Ship(int x, int y, int size, boolean isHorizontal) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.isHorizontal = isHorizontal;
    }
}
