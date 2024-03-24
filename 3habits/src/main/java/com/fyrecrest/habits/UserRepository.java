package com.fyrecrest.habits;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
  public User findById(Long userId) {
    return new User();
  }

  public void save(User user) {
  }

  public int count() {
    return 0;
  }

  public void saveAll(List<User> users) {
  }

  public List<User> findAll() {
    return null;
  }
}
