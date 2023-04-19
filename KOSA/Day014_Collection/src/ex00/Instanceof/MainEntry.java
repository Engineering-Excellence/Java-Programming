package ex00.Instanceof;

class A { }

class B extends A { }

public class MainEntry {

    public static void main(String[] args) {

        A a = new A();
        B b = new B();
//        B a1 = new A();

        System.out.println("a instanceof A: " + (a instanceof A));  // true
        System.out.println("b instanceof A: " + (b instanceof A));  // true
        System.out.println("a instanceof B: " + (a instanceof B));  // false
        System.out.println("b instanceof B: " + (b instanceof B));  // true
    }
}
