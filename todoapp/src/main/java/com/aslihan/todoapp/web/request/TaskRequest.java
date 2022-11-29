package com.aslihan.todoapp.web.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    private Long taskId;
    private String title;
    private String description;
    private Long userId;

}
