package ex07.inner_class;

class OuterClass {  // 외부클래스

    static int no;
    String msg = "Hello!";

    public void outerMethod() {
        System.out.println("outerMethod() Call");
//        System.out.println(num);    // 외부에서는 내부 필드 접근 불가
//        show();
    }

    class InnerClass {  // 내부클래스

        int num = 99;   // 선언한 위치부터 사용 가능

        public void show() {
            System.out.println(num);    // 내부(자신의 것) 사용 가능
            System.out.println(msg);    // 외부클래스 필드 사용 가능
        }

        public void disp() {
            outerMethod();  // 외부클래스 메서드 호출
        }
    }   // InnerClass end
}   // OuterClass end

public class MainEntry {

    public static void main(String[] args) {

        // 1.
        OuterClass oc = new OuterClass();
        OuterClass.InnerClass ic = oc.new InnerClass();
        ic.disp();
        ic.show();

        System.out.println("=".repeat(60));

        // 2.
        OuterClass.InnerClass inner = new OuterClass().new InnerClass();
        inner.show();
    }
}
