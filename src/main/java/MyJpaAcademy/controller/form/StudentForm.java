package MyJpaAcademy.controller.form;

import MyJpaAcademy.domain.Parent;
import MyJpaAcademy.domain.School;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class StudentForm {

    @NotEmpty(message = "이름은 필수 입니다")
    private String name;

    @NotEmpty(message = "생년월일은 필수 입니다")
    private String birth;

    private String address;
    private String phone;
    private Integer grade;
    private Integer schoolClass;
    private String school;
    private String description;
}
