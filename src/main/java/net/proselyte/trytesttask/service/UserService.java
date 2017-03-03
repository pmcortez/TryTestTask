package net.proselyte.trytesttask.service;

import net.proselyte.trytesttask.model.User;

import java.util.List;

/**
 * Created by Irina on 24.02.2017.
 */
public interface UserService {

    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(int id);
    public User getUserById(int id);
    public List<User> listUsers();

    public List<User> findUsers(String name);
}
