package com.taskmanager.task_api.service;

import com.taskmanager.task_api.model.Task;
import com.taskmanager.task_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Criar nova tarefa
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Listar todas as tarefas
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Buscar tarefa por ID
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Buscar tarefas por status
    public List<Task> getTasksByStatus(Boolean completed) {
        return taskRepository.findByCompleted(completed);
    }

    // Buscar tarefas por título
    public List<Task> searchTasksByTitle(String title) {
        return taskRepository.findByTitleContainingIgnoreCase(title);
    }

    // Atualizar tarefa
    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com id: " + id));

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.getCompleted());

        return taskRepository.save(task);
    }

    // Marcar tarefa como concluída/pendente
    public Task toggleTaskStatus(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com id: " + id));

        task.setCompleted(!task.getCompleted());
        return taskRepository.save(task);
    }

    // Deletar tarefa
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada com id: " + id);
        }
        taskRepository.deleteById(id);
    }
}