package MyJpaAcademy.repository;

import MyJpaAcademy.domain.Parent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ParentRepository {
    private final EntityManager em;

    public void save(Parent parent) {
        em.persist(parent);
    }

    public Parent findOne(Long id) {
        return em.find(Parent.class, id);
    }

    public List<Parent> findAll() {
        return em.createQuery("select p from Parent p", Parent.class)
                .getResultList();
    }

    public List<Parent> findByName(String name) {
        return em.createQuery("select p from Parent p where p.name = :name", Parent.class)
                .setParameter("name", name)
                .getResultList();
    }
}
