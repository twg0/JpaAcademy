package MyJpaAcademy.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Lecture {

    @Id @GeneratedValue
    @Column(name = "lecture_id")
    private Long id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToMany(mappedBy = "lecture")
    private List<LectureClass> lectureClasses = new ArrayList<>();

}
