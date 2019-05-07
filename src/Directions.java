public enum Directions {
    UP(213),
    DOWN(123),
    LEFT(123123),
    RIGHT(123123123);

    private int value;

    Directions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}