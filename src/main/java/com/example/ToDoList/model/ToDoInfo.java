package com.example.ToDoList.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoInfo {
  @Id
  @GeneratedValue
  private Long id;
  private String description;
  private Long reminder;

  public Long getId() {
    return id;
  }
  public String getDescription() {
    return description;
  }

  public Long getReminder() {
    return reminder;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setReminder(Long reminder) {
    this.reminder = reminder;
  }
}
