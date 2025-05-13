package com.example.umc.Moment.service;

import com.example.umc.Moment.domain.Category;
import com.example.umc.Moment.domain.Todo;
import com.example.umc.Moment.dto.TodoRequest;
import com.example.umc.Moment.dto.TodoResponse;
import com.example.umc.Moment.repository.CategoryRepository;
import com.example.umc.Moment.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final CategoryRepository categoryRepository;

    public TodoResponse create(TodoRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        Todo todo = new Todo();
        todo.setCategory(category);
        todo.setTitle(request.getTitle());
        todo.setDate(request.getDate());
        todo.setStartTime(request.getStartTime());
        todo.setEndTime(request.getEndTime());
        todo.setEnergyLevel(request.getEnergyLevel());
        todo.setUpperTodoId(request.getUpperTodoId());

        return toResponse(todoRepository.save(todo));
    }

    public List<TodoResponse> findAll() {
        return todoRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public TodoResponse update(Long id, TodoRequest request) {
        Todo todo = todoRepository.findById(id).orElseThrow();

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        todo.setCategory(category);
        todo.setTitle(request.getTitle());
        todo.setDate(request.getDate());
        todo.setStartTime(request.getStartTime());
        todo.setEndTime(request.getEndTime());
        todo.setEnergyLevel(request.getEnergyLevel());
        todo.setUpperTodoId(request.getUpperTodoId());

        return toResponse(todoRepository.save(todo));
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    private TodoResponse toResponse(Todo todo) {
        return TodoResponse.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .date(todo.getDate())
                .startTime(todo.getStartTime())
                .endTime(todo.getEndTime())
                .energyLevel(todo.getEnergyLevel())
                .upperTodoId(todo.getUpperTodoId())
                .categoryId(todo.getCategory().getId())
                .build();
    }
}