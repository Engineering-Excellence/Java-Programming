package quiz.bmi;

import java.io.IOException;

public interface BmiService {

    boolean addBmi() throws IOException;

    void printBmiMap();

    boolean updateBmi() throws IOException;

    boolean deleteBmi() throws IOException;

    boolean saveBmi() throws IOException;
}
