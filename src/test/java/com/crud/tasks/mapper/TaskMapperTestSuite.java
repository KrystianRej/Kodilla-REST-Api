package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTestSuite {
    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void testEachTaskMapper() {
        //Given
        Task task = new Task(1, "title", "content");
        TaskDto taskDto = new TaskDto(1, "title", "content");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        //When
        Task mappedTask = taskMapper.mapToTask(taskDto);
        TaskDto mappedTaskDto = taskMapper.mapToTaskDto(task);
        List<TaskDto> mappedTaskDtoList = taskMapper.mapToTaskDtoList(taskList);

        TaskDto mappedTaskDtoFromTheList = mappedTaskDtoList.get(0);
        //Then
        assertEquals(1, mappedTask.getId());
        assertEquals("title", mappedTask.getTitle());
        assertEquals("content", mappedTask.getContent());

        assertEquals(1, mappedTaskDto.getId());
        assertEquals("title", mappedTaskDto.getTitle());
        assertEquals("content", mappedTaskDto.getContent());

        assertEquals(1, mappedTaskDtoFromTheList.getId());
        assertEquals("title", mappedTaskDtoFromTheList.getTitle());
        assertEquals("content", mappedTaskDtoFromTheList.getContent());
    }
}
