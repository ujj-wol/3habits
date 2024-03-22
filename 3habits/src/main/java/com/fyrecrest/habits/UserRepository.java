package com.fyrecrest.habits;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
  public User findById(Long userId) {
    return new User();
  }

  public void save(User user) {
  }
}
