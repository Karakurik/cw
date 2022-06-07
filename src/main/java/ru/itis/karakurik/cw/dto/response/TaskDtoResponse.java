package ru.itis.karakurik.cw.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.karakurik.cw.model.Task;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TaskDtoResponse {
    private Long id;
    private String name;
    private String startTime;
    private String endTime;

    public static TaskDtoResponse from(Task task) {
        return TaskDtoResponse.builder()
                .id(task.getId())
                .name(task.getName())
                .startTime(task.getStartTime())
                .endTime(task.getEndTime())
                .build();
    }

    public static List<TaskDtoResponse> from(List<Task> tasks) {
        return tasks.stream().map(TaskDtoResponse::from).collect(Collectors.toList());
    }
}
