package ru.based.springcourse.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.based.springcourse.dao.UserDao;
import ru.based.springcourse.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.update(user);
    }
}