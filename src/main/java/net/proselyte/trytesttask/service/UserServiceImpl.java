package net.proselyte.trytesttask.service;

import net.proselyte.trytesttask.dao.UserDao;
import net.proselyte.trytesttask.model.User;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        User user = this.userDao.getUserById(id);
        Hibernate.initialize(user);
        return user;

    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }




    @Override
    @Transactional
    public List<User> findUsers(String name) {
        return this.userDao.findUsers(name);
    }
}