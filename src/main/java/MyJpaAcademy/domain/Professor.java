package MyJpaAcademy.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Professor {

    @Id @GeneratedValue
    @Column(name = "professor_id")
    private Long id;

    private String name;
    private String phone;
    private String address;

    @OneToMany(mappedBy = "professor")
    private List<Lecture> lectures = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Enumerated(EnumType.STRING)
    private Subject subject;

    @Lob
    private String description;

    protected Professor() {
    }

    public Professor(String name, String phone, String address, List<Lecture> lectures, RoleType roleType, Subject subject, String description) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.lectures = lectures;
        this.roleType = roleType;
        this.subject = subject;
        this.description = description;
    }
}
