package com.example.SpringBoot.dao;

import com.example.SpringBoot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<User> getUsersList() {
    return entityManager.createQuery("select u from User u", User.class).getResultList();
  }

  @Override
  public User getUser(int id) {
    return entityManager.find(User.class, id);
  }

  @Override
  public void addUser(User user) {
    entityManager.persist(user);
  }

  @Override
  public void deleteUser(int id) {
    entityManager.remove(entityManager.find(User.class, id));
  }

  @Override
  public void editUser(User user) {
    entityManager.merge(user);
  }
}
