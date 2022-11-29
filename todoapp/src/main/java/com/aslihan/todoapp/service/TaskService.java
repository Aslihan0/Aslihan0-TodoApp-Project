package com.aslihan.todoapp.service;

import com.aslihan.todoapp.entity.Task;
import com.aslihan.todoapp.repository.TaskRepository;
import com.aslihan.todoapp.repository.UserRepository;
import com.aslihan.todoapp.web.request.CreateTaskRequest;
import com.aslihan.todoapp.web.request.TaskRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService{

    private UserRepository userRepository;

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository,UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Task newTask(CreateTaskRequest taskRequest) {
        return taskRepository.save(new Task(taskRequest.getTitle(),taskRequest.getDescription(),"ACTIVE", userRepository.findById(taskRequest.getUserId()).get()));

    }

    @Override
    public boolean deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
        return true;
    }

    @Override
    public Task getTaskByTaskId(Long taskId) {
        return taskRepository.findById(taskId).get();
    }

    @Override
    public Task updateTask(TaskRequest task) {
        Task oldTask = getTaskByTaskId(task.getTaskId());
        oldTask.setTitle(task.getTitle());
        oldTask.setDescription(task.getDescription());
        return taskRepository.save(oldTask);
    }

    @Override
    public boolean changeTaskStatus(Long taskId) {
        Task task = getTaskByTaskId(taskId);
        if (task.getStatus().equals("ACTIVE")) {
            task.setStatus("PASSIVE");
        } else {
            task.setStatus("ACTIVE");
        }
        taskRepository.save(task);
        return true;
    }

    @Override
    public List<Task> getAllTaskByUserId(Long userId) {
       return taskRepository.findByUser_Id(userId);
    }

}
