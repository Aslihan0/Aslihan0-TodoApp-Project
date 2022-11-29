package com.aslihan.todoapp.web.controller;

import com.aslihan.todoapp.entity.Task;
import com.aslihan.todoapp.service.TaskService;
import com.aslihan.todoapp.web.request.CreateTaskRequest;
import com.aslihan.todoapp.web.request.TaskRequest;
import com.aslihan.todoapp.web.request.UserTaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }



    @PostMapping
    public ResponseEntity<?> newTask(@RequestBody CreateTaskRequest taskRequest){
        taskService.newTask(taskRequest);
        return ResponseEntity.ok("success");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTask(@RequestParam(value = "id") Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("success");
    }

    @GetMapping("all")
    public List<Task> getAllTaskByUser(@RequestBody UserTaskRequest userTaskRequest) {
        return taskService.getAllTaskByUserId((userTaskRequest.getUserId()));
    }

    @PutMapping("status")
    public ResponseEntity<?> changeTaskStatus(@RequestParam(value = "id") Long id){

        taskService.changeTaskStatus(id);
        return ResponseEntity.ok("success");

    }

    @PutMapping
    public ResponseEntity<?> updateTask(@RequestBody TaskRequest taskRequest){
        return ResponseEntity.ok(taskService.updateTask(taskRequest));

    }

    @GetMapping
    public Task getTaskById(@RequestParam(value = "id") Long id){
        return taskService.getTaskByTaskId(id);
    }
}
