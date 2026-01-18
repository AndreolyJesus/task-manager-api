package com.taskmanager.task_api.repository;

import com.taskmanager.task_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Busca tarefas por status de conclusão
    List<Task> findByCompleted(Boolean completed);

    // Busca tarefas que contém palavra no título
    List<Task> findByTitleContainingIgnoreCase(String title);
}