package com.fyrecrest.habits;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitController {

  private HabitRepository habitRepository;

  private UserRepository userRepository;

  public HabitController(HabitRepository habitRepository, UserRepository userRepository) {
    this.habitRepository = habitRepository;
    this.userRepository = userRepository;
  }

  // Add a new habit for a user
  @PostMapping
  public Habit addHabit(@RequestBody Habit habit, @PathVariable Long userId) {
    User user = userRepository.findById(userId);
    user.getHabits().add(habit);
    habitRepository.save(habit);
    userRepository.save(user);
    return habit;
  }

  // Mark a habit as completed
  @PutMapping("/{habitId}/completed")
  public Habit markCompleted(@PathVariable Long habitId) {
    Habit habit = habitRepository.findById(habitId);
    habit.setCompletedToday(true);
    habitRepository.save(habit);
    return habit;
  }

  // Get all habits for a user
  @GetMapping("/user/{userId}")
  public List<Habit> getHabitsForUser(@PathVariable Long userId) {
    User user = userRepository.findById(userId);
    return new ArrayList<>(user.getHabits());
  }
}
