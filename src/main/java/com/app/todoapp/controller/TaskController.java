package com.app.todoapp.controller;

import com.app.todoapp.model.Task;
import com.app.todoapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model){//Model like a bag in which you place objects and send them to the HTML page.
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }
    @PostMapping
    public String createTask(@RequestParam String title){//Model like a bag in which you place objects and send them to the HTML page.
        taskService.CreateTask(title);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){//Model like a bag in which you place objects and send them to the HTML page.
        taskService.deleteTask(id);
        return "redirect:/";
    }@GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){//Model like a bag in which you place objects and send them to the HTML page.
        taskService.toggleTask(id);
        return "redirect:/";
    }

}
