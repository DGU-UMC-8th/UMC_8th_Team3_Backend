package com.example.umc.Moment.service;

import com.example.umc.Moment.domain.Todo;
import com.example.umc.Moment.dto.TodoRequest;
import com.example.umc.Moment.dto.TodoResponse;
import com.example.umc.Moment.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {
    public final TodoRepository todoRepository;

    public TodoResponse create(TodoRequest request){
        Todo todo = Todo.builder()
                .title(request.getTitle())
                .completed(request.isCompleted())
                .build();
        return toResponse(todoRepository.save(todo));
    }

    public List<TodoResponse> findAll() {
        return todoRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public TodoResponse update(Long id, TodoRequest request) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.setTitle(request.getTitle());
        todo.setCompleted(request.isCompleted());
        return toResponse(todoRepository.save(todo));
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    private TodoResponse toResponse(Todo todo) {
        return TodoResponse.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .completed(todo.isCompleted())
                .build();
    }
}
