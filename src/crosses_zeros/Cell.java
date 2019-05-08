package crosses_zeros;

public enum Cell {
    EMPTY("_"),
    ZERO("0"),
    CROSS("X");

    private String value;

    Cell(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}