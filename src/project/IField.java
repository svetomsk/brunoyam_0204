package project;

public interface IField {
    // constant size constructors
    void setValue(int x, int y, int value);
    int getValue(int x, int y);
    int size();
    boolean isAllCrashed();
}
