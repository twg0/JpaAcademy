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
    private String Address;

    @OneToMany(mappedBy = "professor")
    private List<Lecture> lectures = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Enumerated(EnumType.STRING)
    private Subject subject;

    @Lob
    private String description;
}
