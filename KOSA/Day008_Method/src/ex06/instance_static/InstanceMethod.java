package ex06.instance_static;

class B {

    int x, y;

    // instance method
    public void setData(int xx, int yy) {
        System.out.println(xx + ", " + yy);
    }
}   // B class end

public class InstanceMethod {

    public static void main(String[] args) {

        B b = new B();  // 객체 생성, 메모리 할당, 생성자 함수 자동호출

        b.setData(22, 55);
    }
}
