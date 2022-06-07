package ru.itis.karakurik.cw.service;

import ru.itis.karakurik.cw.dto.request.TaskDtoRequest;
import ru.itis.karakurik.cw.dto.response.TaskDtoResponse;

import java.util.List;

public interface TaskService {
    List<TaskDtoResponse> getTasks();

    TaskDtoResponse getTask(Long id);

    TaskDtoResponse insert(TaskDtoRequest taskDtoRequest);

    TaskDtoResponse update(Long id, TaskDtoRequest taskDtoRequest);

}
