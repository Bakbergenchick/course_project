package com.atymtay.spring.course_project.repository.impls.hibernateRepoImpls;

import com.atymtay.spring.course_project.entities.LiveCourse;

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
public class HibLiveGenerallRepositoryImpl implements GenerallRepository {

    private static final Log logger = LogFactory.getLog(HibLiveGenerallRepositoryImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public HibLiveGenerallRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<LiveCourse> getAll() {
        Session session = sessionFactory.getCurrentSession();

        List<LiveCourse> liveCourse = session.createQuery("from LiveCourse", LiveCourse.class)
                .getResultList();

        return liveCourse;
    }

    @Override
    public Optional<LiveCourse> getById(Long id) {
        return Optional.of(sessionFactory.getCurrentSession().get(LiveCourse.class, id));
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        LiveCourse employee = session.get(LiveCourse.class, id);

        session.delete(employee);
    }

    @Override
    public Optional getByName(String name) {
        return Optional.empty();
    }

    @Override
    public void save(Object object) {
        LiveCourse new_liveCourse = (LiveCourse) object;
        logger.info("LiveCourse saved with id: " + new_liveCourse.getId());
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(new_liveCourse);


    }

    @Override
    public void update(Object object) {
        LiveCourse new_liveCourse = (LiveCourse) object;
        logger.info("LiveCourse updated with id: " + new_liveCourse.getId());

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(new_liveCourse);
    }


}
