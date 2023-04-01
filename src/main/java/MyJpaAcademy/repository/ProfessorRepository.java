package MyJpaAcademy.repository;

import MyJpaAcademy.domain.Professor;
import MyJpaAcademy.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProfessorRepository {

    private final EntityManager em;

    public void save(Professor professor) {
        em.persist(professor);
    }

    public Professor findOne(Long id) {
        return em.find(Professor.class, id);
    }

    public List<Professor> findAll() {
        return em.createQuery("select p from Professor p", Professor.class)
                .getResultList();
    }

    public List<Professor> findByName(String name) {
        return em.createQuery("select p from Professor p where p.name = :name", Professor.class)
                .setParameter("name", name)
                .getResultList();
    }
}
