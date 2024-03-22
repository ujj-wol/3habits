package com.fyrecrest.habits;

import java.util.Objects;

public class Habit {
  private Long id;

  private String name;

  private boolean completedToday;

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

  public boolean isCompletedToday() {
    return completedToday;
  }

  public void setCompletedToday(boolean completedToday) {
    this.completedToday = completedToday;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Habit habit = (Habit) o;
    return id.equals(habit.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
