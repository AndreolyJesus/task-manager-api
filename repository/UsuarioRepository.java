package com.taskmanager.task_api.repository;

import com.taskmanager.task_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos básicos já vêm prontos:
    // - save()
    // - findById()
    // - findAll()
    // - deleteById()
    // - etc.
}