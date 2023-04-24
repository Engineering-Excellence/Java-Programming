package quiz.bmi;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BmiServiceImpl implements BmiService {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Map<Integer, BmiDTO> BMI_MAP = new HashMap<>();
    static int seq;

    private BmiServiceImpl() {
    }

    private static class LazyHolder {
        private static final BmiService INSTANCE = new BmiServiceImpl();

        private LazyHolder() {
        }
    }

    public static BmiService getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public boolean addBmi() throws IOException {
        System.out.print("'이름 성별 키 몸무게' 순으로 입력하세요.: ");
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BMI_MAP.put(++seq, new BmiDTO(st.nextToken(), st.nextToken().equals("남"), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
        return true;
    }

    @Override
    public void printBmiMap() {
        System.out.println("이름\t성별\t키\t\t몸무게\tBMI\t\t비만도");
        BMI_MAP.forEach((integer, bmiDTO) -> System.out.println(BMI_MAP.get(integer)));
    }

    @Override
    public boolean updateBmi() throws IOException {
        System.out.print("\n수정할 신체정보의 번호를 입력하세요.: ");
        int key = Integer.parseInt(br.readLine());
        BmiDTO bmiDTO = BMI_MAP.get(key);
        if (BMI_MAP.containsKey(key)) {
            System.out.print("\n수정할 신체정보를 입력하세요.(1: 이름, 2: 성별, 3: 키, 4: 몸무게, 그 외: 취소): ");
            String update = br.readLine();
            switch (update.trim()) {
                case "1" -> {
                    System.out.print("이름: ");
                    String name = br.readLine();
                    bmiDTO.setName(name);
                }
                case "2" -> {
                    System.out.print("성별: ");
                    String gender = br.readLine();
                    bmiDTO.setGender(gender.equals("남"));
                }
                case "3" -> {
                    System.out.print("키: ");
                    double height = Double.parseDouble(br.readLine());
                    bmiDTO.setHeight(height);
                    return true;
                }
                case "4" -> {
                    System.out.print("몸무게: ");
                    double weight = Double.parseDouble(br.readLine());
                    bmiDTO.setWeight(weight);
                    return true;
                }
                default -> {
                    System.out.println("신체정보 수정 취소");
                    return false;
                }
            }   // switch-case end
            return true;
        } else {
            System.out.println("신체정보가 존재하지 않습니다.");
            return false;
        }
    }

    @Override
    public boolean deleteBmi() throws IOException {
        System.out.print("\n삭제할 신체정보의 번호를 입력하세요.: ");
        int key = Integer.parseInt(br.readLine());
        if (BMI_MAP.containsKey(key)) {
            BMI_MAP.remove(key);
            return true;
        }
        System.out.println("신체정보가 존재하지 않습니다.");
        return false;
    }

    @Override
    public boolean saveBmi() throws IOException {
        Date date = new Date();
        StringBuilder sb = new StringBuilder();
        String file;

        sb.append("파일 생성 시간: ").append(date).append("\r\n").append("이름\t성별\t키\t\t몸무게\tBMI\t\t비만도\r\n");

        System.out.print("파일 이름 입력: ");
        file = br.readLine();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Map.Entry<Integer, BmiDTO> entry : BMI_MAP.entrySet()) {
            sb.append(entry).append("\r\n");
        }
        bw.write(String.valueOf(sb));
        bw.close();

        return true;
    }
}
