package com.example.ToDoList.repository;

import com.example.ToDoList.model.ToDoInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoInfoRepository extends JpaRepository<ToDoInfo, Long> {
}
