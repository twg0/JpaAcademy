package MyJpaAcademy.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class LectureClass {

    @Id @GeneratedValue
    @Column(name = "lectureclass_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    @Lob
    private String description;
}
