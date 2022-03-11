package com.atymtay.spring.course_project.repository.impls.hibernateRepoImpls;

import com.atymtay.spring.course_project.entities.PermanentCourse;
import com.atymtay.spring.course_project.entities.Users;
import com.atymtay.spring.course_project.repository.GenerallRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HibUserRepositoryImpl implements GenerallRepository {

    private static final Log logger = LogFactory.getLog(HibPermanentGenerallRepositoryImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public HibUserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Users> getAll() {
        Session session = sessionFactory.getCurrentSession();

        List<Users> users_ = session.createQuery("from Users ", Users.class)
                .getResultList();


        return users_;
    }

    @Override
    public Optional<Users> getById(Long id) {
        return Optional.of(sessionFactory.getCurrentSession().get(Users.class, id));
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Users users = session.get(Users.class, id);

        session.delete(users);
    }

    @Override
    public Optional getByName(String name) {
        return Optional.empty();
    }

    @Override
    public void save(Object object) {
        Users new_user = (Users) object;
        logger.info("User saved with id: " + new_user.getId());
        Session session = sessionFactory.getCurrentSession();

        session.save(new_user);
    }

    @Override
    public void update(Object object) {
        Users new_user = (Users) object;
        logger.info("User updated with id: " + new_user.getId());
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(new_user);
    }

    public void addPermanentCourseToUser(Long user_id, Long permanentCourse_id){
        Session session = sessionFactory.getCurrentSession();

        Users user = session.get(Users.class, user_id);

        PermanentCourse permanentCourse = session.get(PermanentCourse.class, permanentCourse_id);

        user.addPermanentCourseToUser(permanentCourse);

        session.save(user);

        logger.info("PermanentCourse with id=" +permanentCourse.getId() + " was saved!");
    }
}
