package ru.itis.karakurik.cw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.karakurik.cw.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
