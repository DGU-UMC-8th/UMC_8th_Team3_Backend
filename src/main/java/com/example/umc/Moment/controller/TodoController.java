package com.example.umc.Moment.controller;

import com.example.umc.Moment.dto.TodoRequest;
import com.example.umc.Moment.dto.TodoResponse;
import com.example.umc.Moment.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Todo API", description = "할 일(Todo) 관리용 API")
@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @Operation(summary = "할 일 등록", description = "새로운 할 일을 등록합니다.")
    @PostMapping
    public TodoResponse create(@RequestBody TodoRequest request){
        return todoService.create(request);
    }

    @Operation(summary = "할 일 전체 조회", description = "등록된 모든 할 일을 반환합니다.")
    @GetMapping
    public List<TodoResponse> findAll() {
        return todoService.findAll();
    }

    @Operation(summary = "할 일 수정", description = "기존 할 일 정보를 수정합니다.")
    @PutMapping("/{id}")
    public TodoResponse update(@PathVariable Long id, @RequestBody TodoRequest request){
        return todoService.update(id, request);
    }

    @Operation(summary = "할 일 삭제", description = "ID로 할 일을 삭제합니다.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        todoService.delete(id);
    }

}