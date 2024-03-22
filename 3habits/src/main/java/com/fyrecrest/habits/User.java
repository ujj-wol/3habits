package com.fyrecrest.habits;

import java.util.List;
import java.util.Objects;

public class User {
  private Long id;

  private String name;

  private List<Habit> habits;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return id.equals(user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public List<Habit> getHabits() {
    return null;
  }

  public void setHabits(List<Habit> habits) {
    this.habits = habits;
  }
}
