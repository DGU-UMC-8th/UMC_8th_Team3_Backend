package com.example.umc.Moment.repository;

import com.example.umc.Moment.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
