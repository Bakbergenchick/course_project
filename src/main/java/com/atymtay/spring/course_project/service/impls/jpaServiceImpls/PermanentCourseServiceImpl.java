package com.atymtay.spring.course_project.service.impls.jpaServiceImpls;

import com.atymtay.spring.course_project.entities.PermanentCourse;


import com.atymtay.spring.course_project.entities.Topic;
import com.atymtay.spring.course_project.repository.impls.jpaRepoImpls.PermanentRepository;
import com.atymtay.spring.course_project.repository.impls.jpaRepoImpls.TopicRepository;
import com.atymtay.spring.course_project.service.GenerallService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class PermanentCourseServiceImpl implements GenerallService {

    private static final Log logger = LogFactory.getLog(PermanentCourseServiceImpl.class);

    private final PermanentRepository permanentRepository;

    private final TopicRepository topicRepository;

    @Autowired
    public PermanentCourseServiceImpl(PermanentRepository permanentRepository, TopicRepository topicRepository) {
        this.permanentRepository = permanentRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PermanentCourse> getAll() {
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

        return permanentRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Object object) {
        permanentRepository.save((PermanentCourse) object);
    }

    @Override
    public void update(Object object) {
        permanentRepository.save((PermanentCourse) object);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PermanentCourse> getById(Long id) {
        return Optional.of(permanentRepository.getById(id));
    }

    @Override
    public void deleteById(Long id) {
        permanentRepository.deleteById(id);
    }

    @Transactional
    public void addTopicToPermanentCourse(Topic topic, Long id){

        PermanentCourse permanentCourse = permanentRepository.getById(id);

        logger.info("Topic was added to permanentCourse={ " + permanentCourse + " }");

        Set<Topic> topics = permanentCourse.getTopicList();

        topics.add(topic);

        topic.setPermanentCourse(permanentCourse);

        permanentRepository.save(permanentCourse);

        topicRepository.save(topic);

        logger.info("Topic with id=" + topic.getId() + " was saved!");
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void removeTopicFromPermanentCourse(Long id){

        Topic topic = topicRepository.getById(id);

        topicRepository.delete(topic);

        logger.info("Topic with id=" + topic.getId()  + " was deleted!");

    }
}
