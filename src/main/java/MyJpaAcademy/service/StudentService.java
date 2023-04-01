package MyJpaAcademy.service;

import MyJpaAcademy.domain.Student;
import MyJpaAcademy.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(Student student) {
        validateDuplicateStudent(student); // 중복 학생 검증
        studentRepository.save(student);
        return student.getId();
    }

    public void validateDuplicateStudent(Student student) {
        List<Student> findStudents = studentRepository.findByName(student.getName());
        if (!findStudents.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 학생입니다.");
        }
    }

    // 학생 전체 조회
    public List<Student> findStudents() {
        return studentRepository.findAll();
    }

    public Student findOne(Long studentId) {
        return studentRepository.findOne(studentId);
    }
}
