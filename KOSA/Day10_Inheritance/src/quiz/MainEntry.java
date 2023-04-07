package quiz;

public class MainEntry {

    public static void main(String[] args) {

        Sales sales = new Sales(142857, "자바맨", "사무관", "중소벤처기업부", "010-1234-5678");
        System.out.println(sales);

        PartTime partTime = new PartTime(15324265, "아무개", "기간제근로자", "보건복지부", "010-1532-4265", 22);
        System.out.println(partTime);
    }
}
