package com.example.To_Do.List.App.controller;

import org.springframework.ui.Model;
import com.example.To_Do.List.App.model.Task;
import com.example.To_Do.List.App.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String viewAllTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks/list";  // Thymeleaf view
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("task", new Task());
        return "tasks/add";  // Thymeleaf view for adding a task
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        taskService.saveTask(task);  // Delegate the saving to TaskService
        return "redirect:/tasks";  // Redirect back to task list
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id).orElseThrow();
        model.addAttribute("task", task);
        return "tasks/edit";  // Thymeleaf view for editing a task
    }

    @PostMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, @ModelAttribute Task task) {
        task.setId(id);
        taskService.updateTask(task);  // Delegate the update to TaskService
        return "redirect:/tasks";  // Redirect back to task list
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);  // Delegate the delete to TaskService
        return "redirect:/tasks";  // Redirect back to task list
    }




}
