package MyJpaAcademy.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Parent {

    @Id @GeneratedValue
    @Column(name = "parent_id")
    private Long id;

    private String name;
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
}
