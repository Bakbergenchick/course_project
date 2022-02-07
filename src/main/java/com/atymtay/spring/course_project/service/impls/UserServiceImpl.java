package com.atymtay.spring.course_project.service.impls;

import com.atymtay.spring.course_project.entities.Users;
import com.atymtay.spring.course_project.repository.UsersRepository;
import com.atymtay.spring.course_project.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public void saveUser(Users user) {
        usersRepository.save(user);
    }

    @Override
    public Optional<Users> getUser(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }




}
