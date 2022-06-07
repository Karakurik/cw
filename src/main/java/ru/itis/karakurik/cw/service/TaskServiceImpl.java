package ru.itis.karakurik.cw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.karakurik.cw.dto.request.TaskDtoRequest;
import ru.itis.karakurik.cw.dto.response.TaskDtoResponse;
import ru.itis.karakurik.cw.exception.TaskNotFoundException;
import ru.itis.karakurik.cw.model.Task;
import ru.itis.karakurik.cw.repository.TaskRepository;

import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public List<TaskDtoResponse> getTasks() {
        return TaskDtoResponse.from(taskRepository.findAll());
    }

    @Override
    public TaskDtoResponse getTask(Long id) {
        return TaskDtoResponse.from(taskRepository.findById(id).orElseThrow(TaskNotFoundException::new));
    }

    @Override
    public TaskDtoResponse insert(TaskDtoRequest taskDtoRequest) {
        return TaskDtoResponse.from(taskRepository.save(Task.builder().name(taskDtoRequest.getName()).startTime(LocalTime.now().toString()).endTime(LocalTime.now().plusHours(taskDtoRequest.getHours()).toString()).build()));
    }

    @Override
    public TaskDtoResponse update(Long id, TaskDtoRequest taskDtoRequest) {
        Task task = taskRepository.findById(id).orElseThrow(TaskNotFoundException::new);

        task.setName(taskDtoRequest.getName());
        if (taskDtoRequest.getHours() != null) {
            task.setStartTime(LocalTime.now().toString());
            task.setEndTime(LocalTime.now().plusHours(taskDtoRequest.getHours()).toString());
        }

        return TaskDtoResponse.from(taskRepository.save(task));
    }
}
