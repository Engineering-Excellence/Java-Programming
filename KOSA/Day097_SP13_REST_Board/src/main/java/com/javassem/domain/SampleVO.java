package com.javassem.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

//@Data - 를 하면 @AllArgsConstructor 이 안 먹히는데
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
//@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SampleVO {

    private String name;
    private Integer age;        // pathValue    ,    path_value
    private String message;
    @JsonProperty(value = "phone_number")
    private String phoneNumber;
    @JsonProperty(value = "PINNUMBER")
    private String PINNUMBER;

    /*
     * @Data = @Getter/@Setter + @ToString + @EqualsAndHashCode + @RequriedArgsConstructor
     */

    /*
     * public SampleVO() {
     *
     * } public SampleVO(String name, int age, String message) { super(); this.name
     * = name; this.age = age; this.message = message; }
     *
     *
     * public String getName() { return name; } public void setName(String name) {
     * this.name = name; } public int getAge() { return age; } public void
     * setAge(int age) { this.age = age; } public String getMessage() { return
     * message; } public void setMessage(String message) { this.message = message; }
     */
}
