package MyJpaAcademy.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
public class School {

    @Id
    @GeneratedValue
    @Column(name = "school_id")
    private Long id;

    private String phone;

    private Date testDate;

    @OneToOne(fetch = FetchType.LAZY)
    private Student student;

    @Lob
    private String description;
}