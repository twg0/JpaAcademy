package MyJpaAcademy.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class TakeLecture {

    @Id @GeneratedValue
    @Column(name = "takelecture")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lecture lecture;
}
