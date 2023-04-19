package ex02.oop;

//import java.lang.*; // 항상 자동으로 import

class Point /*extends Object*/ {    // 항상 자동으로 상속받음

    // 접근 제한자: private < (default) < protected < public
    private int x, y;   // 멤버변수, 필드: 자동으로 초기화

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x; // this: 객체 생성시 주소값(자기 자신)
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void display() {
        System.out.printf("%d, %d%n", getX(), y);
        System.out.printf("%d, %d%n", x, y);
    }
}   // Point class end

public class MainEntry {

    public static void main(String[] args) {

        Point pt = new Point();
        System.out.println(pt.getX());
        pt.setX(1000);
        System.out.println(pt.getX());
//        System.out.println(pt.x);
//        pt.display();
//        int xx;
//        System.out.println(xx); // 지역변수는 사용하기 전에 반드시 초기화해야함
    }
}   // MainEntry class end
