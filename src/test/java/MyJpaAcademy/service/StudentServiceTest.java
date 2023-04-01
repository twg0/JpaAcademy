package MyJpaAcademy.service;

import MyJpaAcademy.domain.Student;
import MyJpaAcademy.repository.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class StudentServiceTest {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    @Test
    public void 회원가입() throws Exception {
        // given
        Student student = new Student("재혁", null,null,null,null,null,null,null,null);

        // when
        Long savedId = studentService.join(student);

        // then
        assertEquals(student, studentRepository.findOne(savedId));

    }

    @Test
    public void 중복_회원_예외() throws Exception {
        // given
        Student student1 = new Student("재혁",null, null,null,null,null,null,null,null);
        Student student2 = new Student("재혁",null, null,null,null,null,null,null,null);
        // when
        studentService.join(student1);
        // then
        try{
            studentService.join(student2);
        } catch(IllegalStateException e){
            System.out.println("잡았다");
        }
    }

}