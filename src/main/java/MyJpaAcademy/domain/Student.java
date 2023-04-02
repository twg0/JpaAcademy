package MyJpaAcademy.domain;


import lombok.Getter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
public class Student {

    @Id @GeneratedValue
    @Column(name = "student_id")
    private Long id;

    private String name;
    private String birth;
    private String address;
    private String phone;
    private Integer grade;
    private Integer schoolClass;

    @OneToMany(mappedBy = "student")
    private List<Parent> parents = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    private School school;

    @Lob
    private String description;

    protected Student() {
    }

    public Student(String name, String birth, String address, String phone, Integer grade, Integer schoolClass, School school, String description) {
        this.name = name;
        this.birth = birth;
        this.address = address;
        this.phone = phone;
        this.grade = grade;
        this.schoolClass = schoolClass;
        this.school = school;
        this.description = description;
    }
}
