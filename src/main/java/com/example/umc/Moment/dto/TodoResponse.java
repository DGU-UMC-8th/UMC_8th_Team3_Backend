package com.example.umc.Moment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoResponse {
    private Long id;
    private String title;
    private boolean completed;
}
