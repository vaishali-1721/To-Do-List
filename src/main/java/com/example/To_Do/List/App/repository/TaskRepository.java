package com.example.To_Do.List.App.repository;

import com.example.To_Do.List.App.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // You can add custom queries here if needed
}
