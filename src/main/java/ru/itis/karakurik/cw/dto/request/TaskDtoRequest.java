package ru.itis.karakurik.cw.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TaskDtoRequest {

    @NotBlank(message = "Имя не может быть пустым")
    private String name;

    @Positive(message = "Количество часов на задачу не может быть отрицательный или ноль")
    private Long hours;
}
