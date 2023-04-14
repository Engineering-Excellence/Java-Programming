package quiz.map;

import java.text.SimpleDateFormat;
import java.util.Date;

// Model
public class VideoDTO {

    // Field
    private int no;
    private String title;
    private String category;
    private boolean lend;
    private String lendName;
    private Date lendDate;

    // Constructor
    public VideoDTO(int no, String title, String category, String lendName) {
        this.no = no;
        this.title = title;
        this.category = category;
        this.lend = true;
        this.lendName = lendName;
        this.lendDate = new Date();
    }

    // Getters & Setters
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isLend() {
        return lend;
    }

    public void setLend(boolean lend) {
        this.lend = lend;
    }

    public String getLendName() {
        return lendName;
    }

    public void setLendName(String lendName) {
        this.lendName = lendName;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("비디오번호: %d, 비디오제목: %s, 장르: %s, 대여여부: %s, 고객명: %s, 대여일자: %s%n%s",no, title, category, lend, lendName, sdf.format(lendDate), "-".repeat(120));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoDTO videoDTO = (VideoDTO) o;

        if (no != videoDTO.no) return false;
        if (lend != videoDTO.lend) return false;
        if (!title.equals(videoDTO.title)) return false;
        if (!category.equals(videoDTO.category)) return false;
        if (!lendName.equals(videoDTO.lendName)) return false;
        return lendDate.equals(videoDTO.lendDate);
    }

    @Override
    public int hashCode() {
        int result = no;
        result = 31 * result + title.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + (lend ? 1 : 0);
        result = 31 * result + lendName.hashCode();
        result = 31 * result + lendDate.hashCode();
        return result;
    }
}
