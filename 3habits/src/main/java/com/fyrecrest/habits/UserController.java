package com.fyrecrest.habits;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  private HabitRepository habitRepository;

  private UserRepository userRepository;

  public UserController(HabitRepository habitRepository, UserRepository userRepository) {
    this.habitRepository = habitRepository;
    this.userRepository = userRepository;
  }

  // Get user by id
  @GetMapping("/user/{userId}")
  public User getUserById(@PathVariable Long userId) {
    User user = userRepository.findById(userId);
    return user;
  }

  // Get all users
  @GetMapping
  public List<User> getUsers() {
    List<User> users = userRepository.findAll();
    return users;
  }
}
