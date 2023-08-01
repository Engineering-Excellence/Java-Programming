package ex01.di;

import lombok.Data;

import java.util.Scanner;

@Data
public class PlayerImpl implements Player {

    private String name, position, sport;

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("선수명: ");
        this.name = sc.next();
        System.out.print("포지션: ");
        this.position = sc.next();
        System.out.print("종목: ");
        this.sport = sc.next();
    }

    @Override
    public void info() {
        System.out.println("\n=-=-=-= 선수 정보 =-=-=-=");
        System.out.printf("선수명: %s%n", this.name);
        System.out.printf("포지션: %s%n", this.position);
        System.out.printf("종목: %s%n", this.sport);
    }
}
