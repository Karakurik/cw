package ru.itis.karakurik.cw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.karakurik.cw.dto.request.TaskDtoRequest;
import ru.itis.karakurik.cw.dto.response.TaskDtoResponse;
import ru.itis.karakurik.cw.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<TaskDtoResponse>> getTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }


    @GetMapping("/{task-id}")
    public ResponseEntity<TaskDtoResponse> getTask(@PathVariable("task-id") Long id) {
        return ResponseEntity.ok(taskService.getTask(id));
    }

    @PostMapping("/")
    public ResponseEntity<TaskDtoResponse> saveTask(@RequestBody TaskDtoRequest taskDtoRequest) {
        return ResponseEntity.ok(taskService.insert(taskDtoRequest));
    }

    // Надеюсь patch имеет тело ответа, а не put
    @PatchMapping("/{task-id}")
    public ResponseEntity<?> updateTask(@PathVariable("task-id") Long id,
                                        @RequestBody TaskDtoRequest taskDtoRequest) {
        taskService.update(id, taskDtoRequest);
        return ResponseEntity.ok().build();
    }
}
