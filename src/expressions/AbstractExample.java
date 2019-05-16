package expressions;

import java.util.ArrayList;
import java.util.List;

public class AbstractExample {
    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        list.add(new B());
        list.add(new C());
        for (A a : list) {
            a.hello();
        }
    }
}

abstract class A {

    public void foo() {
        hello();
    }

    public abstract void hello();
}

class B extends A {
    @Override
    public void hello() {
        System.out.println("do something");
    }
}

class C extends A {
    @Override
    public void hello() {
        System.out.println("C do something ");
    }
}
