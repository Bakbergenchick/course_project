package com.atymtay.spring.course_project.repository.impls.hibernateRepoImpls;

import com.atymtay.spring.course_project.entities.PermanentCourse;
import com.atymtay.spring.course_project.entities.Topic;
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
public class HibPermanentGenerallRepositoryImpl implements GenerallRepository {

    private static final Log logger = LogFactory.getLog(HibPermanentGenerallRepositoryImpl.class);


    private SessionFactory sessionFactory;

    @Autowired
    public HibPermanentGenerallRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<PermanentCourse> getAll() {
        Session session = sessionFactory.getCurrentSession();

        List<PermanentCourse> permanentCourses = session.createQuery("from PermanentCourse", PermanentCourse.class)
                .getResultList();


        return permanentCourses;
    }

    @Override
    public Optional<PermanentCourse> getById(Long id) {
        return Optional.of(sessionFactory.getCurrentSession().get(PermanentCourse.class, id));
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        PermanentCourse permanentCourse = session.get(PermanentCourse.class, id);

        session.delete(permanentCourse);
    }

    @Override
    public Optional getByName(String name) {
        return Optional.empty();
    }

    @Override
    public void save(Object object) {
        PermanentCourse new_permanentCourse = (PermanentCourse) object;
        logger.info("PermanentCourse saved with id: " + new_permanentCourse.getId());
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(new_permanentCourse);
    }

    @Override
    public void update(Object object) {
        PermanentCourse new_permanentCourse = (PermanentCourse) object;
        logger.info("PermanentCourse updated with id: " + new_permanentCourse.getId());

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(new_permanentCourse);
    }

    public void addTopicToPermanentCourse(Topic topic, Long id){
        Session session = sessionFactory.getCurrentSession();

        PermanentCourse permanentCourse = session.get(PermanentCourse.class, id);

        logger.info("Topic was added to permanentCourse={ " + permanentCourse + " }");

        session.save(topic);

        permanentCourse.addTopicToPermanentCourse(topic);

        session.save(permanentCourse);

        logger.info("Topic with id=" + topic.getId() + " was saved!");
    }

    public void removeTopicFromPermanentCourse(Long id){
        Session session = sessionFactory.getCurrentSession();

        Topic topic = session.get(Topic.class, id);

        session.delete(topic);

        logger.info("Topic with id=" + topic.getId()  + " was deleted!");

    }

}
