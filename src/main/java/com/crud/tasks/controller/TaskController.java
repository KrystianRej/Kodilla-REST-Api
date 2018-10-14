package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks() {
        List<TaskDto> tasks = new ArrayList<>();
        TaskDto taskDto = new TaskDto(1L, "test title", "test_content");
        tasks.add(taskDto);
        return tasks;
    }
    @RequestMapping(method = RequestMethod.GET, value = "getTask")
    public TaskDto getTask(Long taskid){
        return new TaskDto(1L, "test title", "test_content");
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public void deleteTask(Long taskid) {

    }
    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
    public TaskDto updateTask(Long taskid) {
        return new TaskDto(1L, "Edited test title", "Test content");
    }
    @RequestMapping(method = RequestMethod.POST, value = "createTask")
    public void createTask (TaskDto taskDto) {

    }
}
