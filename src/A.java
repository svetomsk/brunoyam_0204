public class A {
    private int value = 314;

    public A(int value) {
        this.value = value;
    }

    public void veryLongMethod(String msg) {
        System.out.println(msg);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class B extends A {

    public B(int value) {
        super(value);
    }

    public void foo() {
        System.out.println(super.getValue());
    }

    @Override
    public void veryLongMethod(String msg) {
        System.out.println("!" + msg + "!");
    }
}

class C extends B {
    public C(int value) {
        super(value);
    }

    public void say() {
        getValue();
    }

    @Override
    public void veryLongMethod(String msg) {
        System.out.println("hello");
    }
}

class Mmain {
    public static void main(String[] args) {
        A a = new A(123);
        a.veryLongMethod("hello");

        B b = new B(2131);
        b.veryLongMethod("sdfdf");
//        b.print("asdfsdf");
//
        C c = new C(12312);
        c.veryLongMethod("dfsdfsdfsdf");
//        c.getValue();
//        c.print("sdfsdfsdds");
    }
}
