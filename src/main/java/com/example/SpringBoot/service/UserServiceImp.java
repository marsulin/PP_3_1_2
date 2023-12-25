package com.example.SpringBoot.service;

import com.example.SpringBoot.dao.UserDao;
import com.example.SpringBoot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImp implements UserService{

  private final UserDao userDao;

  public UserServiceImp(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  @Transactional(readOnly = true)
  public List<User> getUsersList() {
    return userDao.getUsersList();
  }

  @Override
  @Transactional(readOnly = true)
  public User getUser(int id) {
    return userDao.getUser(id);
  }

  @Override
  @Transactional
  public void addUser(User user) {
    userDao.addUser(user);
  }

  @Override
  @Transactional
  public void deleteUser(int id) {
    userDao.deleteUser(id);
  }

  @Override
  @Transactional
  public void editUser(User user) {
    userDao.editUser(user);
  }
}
