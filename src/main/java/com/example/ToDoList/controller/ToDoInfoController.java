package com.example.ToDoList.controller;

import com.example.ToDoList.model.ToDoInfo;
import com.example.ToDoList.repository.ToDoInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ToDoInfoController {
  @Autowired
  private ToDoInfoRepository toDoInfoRepository;

  @GetMapping("./")
  public String main() {
    return "Main Page";
  }
  @PostMapping("./add-new-todo")
  public String addNewToDo(@RequestBody ToDoInfo toDoModel) {
    toDoInfoRepository.save(toDoModel);
    return "new to do list added";
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
