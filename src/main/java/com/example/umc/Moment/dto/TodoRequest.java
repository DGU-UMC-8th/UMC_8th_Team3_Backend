package com.example.umc.Moment.dto;

import com.example.umc.Moment.domain.EnergyLevel;
import lombok.Getter;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class TodoRequest {
    private String title;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private EnergyLevel energyLevel;
    private Long upperTodoId;
}