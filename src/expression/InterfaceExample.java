package expression;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface InterfaceExample {

    default int foo() {
        return 1;
    }
    String parseParams();
    void invalidateFunction();
    void testProgram();
}

class FirstProgram {
    InterfaceExample value;

    void init() {
        value = new InterfaceExampleImpl();
    }

    void action() {
        value.invalidateFunction();
        value.testProgram();
        String params = value.parseParams();
    }
}


class InterfaceExampleImpl implements InterfaceExample {

    @Override
    public String parseParams() {
        return null;
    }

    @Override
    public void invalidateFunction() {

    }

    @Override
    public void testProgram() {

    }
}
