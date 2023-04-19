package ex06.instance_static;

class A {

    int x, y;

    // static method
    public static void setData(int xx, int yy) {
        System.out.println(xx + ", " + yy);
    }
}   // A class end

public class StaticMethod {

    public static void main(String[] args) {

//        A a = new A();  // 객체 생성, 메모리 할당, 생성자 함수 자동호출 → static은 불필요
//        a.setData(20, 33);    // object.methodName();
//        a.x = 999;

        A.setData(100, 500);    // ClassName.methodName();
        A.setData(3, 4);

    }
}
