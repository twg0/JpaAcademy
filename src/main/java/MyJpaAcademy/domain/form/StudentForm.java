package MyJpaAcademy.domain.form;

import MyJpaAcademy.domain.Parent;
import MyJpaAcademy.domain.School;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StudentForm {
    private String name;

    private String address;
    private String phone;
    private Integer grade;
    private Integer schoolClass;

    private School school;

    private String description;
}
