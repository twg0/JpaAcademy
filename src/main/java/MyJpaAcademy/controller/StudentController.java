package MyJpaAcademy.controller;

import MyJpaAcademy.domain.Student;
import MyJpaAcademy.controller.form.StudentForm;
import MyJpaAcademy.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students/new")
    public String createStudent(Model model) {
        model.addAttribute("studentForm", new StudentForm());
        return "students/createStudent";
    }

    @PostMapping("/students/new")
    public String create(@Valid StudentForm form, BindingResult result) {

        if(result.hasErrors()) {
            return "students/createStudent";
        }

        Student student = new Student(form.getName(), form.getBirth(), form.getAddress(), form.getPhone(), form.getGrade(),
                form.getSchoolClass(), null, form.getDescription());
        studentService.join(student);
        return "redirect:/";
    }


}
