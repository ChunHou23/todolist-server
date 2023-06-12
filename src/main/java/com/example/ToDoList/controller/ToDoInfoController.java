package com.example.ToDoList.controller;

import com.example.ToDoList.model.ToDoInfo;
import com.example.ToDoList.repository.ToDoInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ToDoInfoController {
  @Autowired
  private ToDoInfoRepository toDoInfoRepository;

  @PostMapping("/add-new-todo")
  public String addNewToDo(@RequestBody ToDoInfo toDoModel) {
    toDoInfoRepository.save(toDoModel);
    return "new to do list added";
  }

  @PostMapping("/add")
  public String add(@RequestBody String test) {
    return test;
  }
  @PutMapping("/update-todo-status/{id}")
  public ToDoInfo updateTodoStatusById(@PathVariable Long id) {
    ToDoInfo toDoInfo = toDoInfoRepository.findById(id).orElseThrow(() -> new InvalidConfigurationPropertyValueException("UPDATE FAILED", id, "Invalid To-Do Item"));
    toDoInfo.setStatus(true);
    toDoInfoRepository.save(toDoInfo);

    return toDoInfo;
  }

  @DeleteMapping("/delete-todo-item/{id}")
  public List<ToDoInfo> deleteTodoItemById(@PathVariable Long id) {
    toDoInfoRepository.deleteById(id);
    return toDoInfoRepository.findAll();
  }

  @GetMapping("/get-all-todo")
  public List<ToDoInfo> getAllToDo() {
    return toDoInfoRepository.findAll();
  }

  @GetMapping("/get-todo/{id}")
  public Optional<ToDoInfo> getToDoById(@PathVariable Long id) {
    return toDoInfoRepository.findById(id);
  }
}
