package com.atymtay.spring.course_project.service.impls.jpaServiceImpls;

import com.atymtay.spring.course_project.entities.PermanentCourse;
import com.atymtay.spring.course_project.entities.Users;
import com.atymtay.spring.course_project.repository.impls.jpaRepoImpls.PermanentRepository;
import com.atymtay.spring.course_project.repository.impls.jpaRepoImpls.UsersRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    UsersRepository usersRepository;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAll() {
        when(usersRepository.findAll())
                .thenReturn(List.of());

        List<Users> result = userServiceImpl.getAll();
        Assertions.assertNotNull(result);
    }

    @Test
    void testGetAll2() {
        when(usersRepository.findAll())
                .thenReturn(
                        List.of(
                                new Users(1L, "Bakbergen", "Atymtay", "email", "1234", new HashSet<>()),
                                new Users(2L, "Azamat", "Umbetov", "34try", "23s4fkj", new HashSet<>())
                        ));

        List<Users> result = userServiceImpl.getAll();

        Assertions.assertEquals("email", result.get(0).getEmail());
    }

    @Test
    void testGetPaged() {
        when(usersRepository.findAll(PageRequest.of(1, 3)))
                .thenReturn(new PageImpl<>(List.of(
                        new Users(1L, "Bakbergen", "Atymtay", "email", "1234", new HashSet<>()),
                        new Users(2L, "Azamat", "Umbetov", "34try", "23s4fkj", new HashSet<>()),
                        new Users(3L, "Azamat", "Umbetov", "34try", "23s4fkj", new HashSet<>()),
                        new Users(3L, "Azamat", "Umbetov", "34try", "23s4fkj", new HashSet<>())
                )));

        Page<Users> result = userServiceImpl.getPaged(1, 3);

        Assertions.assertEquals(2, result.getTotalPages());
    }

    @Test
    void testSave() {
        Users user  =
                new Users(1L, "awd", "awd", "Awd", "Awd", new HashSet<>());

        userServiceImpl.save(user);

        verify(usersRepository, times(1))
                .save(user);
    }

    @Test
    void testUpdate() {

        Users user  =
                new Users(1L, "awd", "awd", "Awd", "Awd", new HashSet<>());

        userServiceImpl.save(user);

        verify(usersRepository, times(1))
                .save(user);

        user.setName("dfgdrgdrg");

        userServiceImpl.update(user);

        verify(usersRepository, times(2))
                .save(user);

    }

    @Test
    void testGetById() {
        Users user = new Users(1L, "Bakbergen", "Atymtay",
                "email", "1234", new HashSet<>());

        when(usersRepository.findById(user.getId()))
                .thenReturn(Optional.of(user));

        Optional<Users> users = userServiceImpl.getById(1L);

        Assertions.assertEquals(Optional.of(user), users);
    }

    @Test
    void testDeleteById() {

        userServiceImpl.deleteById(1L);

        verify(usersRepository, times(1))
                .deleteById(1L);
    }

    @Test
    void testAddPermanentCourseToUser() {

        userServiceImpl.addPermanentCourseToUser(Long.valueOf(1), Long.valueOf(1));
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme