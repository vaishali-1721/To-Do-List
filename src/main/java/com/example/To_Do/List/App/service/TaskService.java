package com.example.To_Do.List.App.service;

import com.example.To_Do.List.App.model.Task;
import com.example.To_Do.List.App.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public void saveTask(Task task) {
        taskRepository.save(task);  // This method will save or update the task in the database
    }

    public void updateTask(Task task) {
        taskRepository.save(task);  // This method handles updates as well by saving the task
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);  // Delete task by its ID
    }
}
