package MyJpaAcademy.service;

import MyJpaAcademy.domain.Professor;
import MyJpaAcademy.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(Professor professor) {
        validateDuplicateProfessor(professor); // 중복 학생 검증
        professorRepository.save(professor);
        return professor.getId();
    }

    public void validateDuplicateProfessor(Professor professor) {
        List<Professor> findProfessors = professorRepository.findByName(professor.getName());
        if (!findProfessors.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 학생입니다.");
        }
    }

    // 교수 전체 조회
    public List<Professor> findProfessors() {
        return professorRepository.findAll();
    }

    public Professor findOne(Long professorId) {
        return professorRepository.findOne(professorId);
    }
}
