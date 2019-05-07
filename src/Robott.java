

public class Robott {
    private static final char DEFAULT_TRACE = '#';

    private static final int DEFAULT_X = 0;
    private static final int DEFAULT_Y = 0;

    private int x;
    private int y;
    private Directions coolDirection;
    private char trace;

    public Robott() {
        this(DEFAULT_X, DEFAULT_Y, Directions.UP, DEFAULT_TRACE);
    }

    public Robott(int x, int y) {
        this(x, y, Directions.UP, DEFAULT_TRACE);
    }

    public Robott(int x, int y, Directions dir) {
        this(x, y, Directions.UP, DEFAULT_TRACE);
    }

    public Robott(int x, int y, Directions dir, char trace) {
        this.x = x;
        this.y = y;
        this.coolDirection = dir;
        this.trace = trace;
    }

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

    public char getTrace() {
        return trace;
    }

    public void setTrace(char trace) {
        this.trace = trace;
    }

    public Directions getCoolDirection() {
        return coolDirection;
    }

    public void setCoolDirection(Directions coolDirection) {
        this.coolDirection = coolDirection;
    }

}
