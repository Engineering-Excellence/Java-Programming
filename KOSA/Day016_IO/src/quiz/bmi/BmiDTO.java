package quiz.bmi;

// BMI = weight / height^2
public class BmiDTO {

    private String name;
    private boolean gender;
    private double height;
    private double weight;
    private double bmi;
    private String obesity;

    public BmiDTO(String name, boolean gender, double height, double weight) {
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        calcBmi();
    }

    private void calcBmi() {
        bmi = weight / Math.pow(height / 100, 2);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        calcBmi();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
        calcBmi();
    }

    public double getBmi() {
        return bmi;
    }

    public String getObesity() {
        return obesity;
    }

    public void setObesity(String obesity) {
        this.obesity = obesity;
    }

    @Override
    public String toString() {
        return String.format("%-4s\t%-4s\t%-5.1f\t%-5.1f\t%-4.1f\t%s", name, gender ? "남" : "여", height, weight, bmi, obesity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BmiDTO bmiDTO = (BmiDTO) o;

        if (Double.compare(bmiDTO.weight, weight) != 0) return false;
        if (Double.compare(bmiDTO.height, height) != 0) return false;
        return gender == bmiDTO.gender;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(weight);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (gender ? 1 : 0);
        return result;
    }
}
