package com.aslihan.todoapp.service;

import com.aslihan.todoapp.entity.Task;
import com.aslihan.todoapp.web.request.CreateTaskRequest;
import com.aslihan.todoapp.web.request.TaskRequest;

import java.util.List;

public interface ITaskService {
    Task newTask(CreateTaskRequest taskRequest);
    List<Task> getAllTaskByUserId(Long userId);
    boolean deleteTask(Long taskId);
    Task getTaskByTaskId(Long taskId);
    Task updateTask(TaskRequest task);
    boolean changeTaskStatus(Long taskId);

}
