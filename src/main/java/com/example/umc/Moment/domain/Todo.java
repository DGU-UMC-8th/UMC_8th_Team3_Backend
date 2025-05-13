package com.example.umc.Moment.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor
public class Todo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false, length = 100)
    private String title;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    @Enumerated(EnumType.STRING)
    private EnergyLevel energyLevel;

    private Long upperTodoId;

    public void setCategory(Category category) {
    }

    public void setTitle(String title) {
    }

    public void setDate(LocalDate date) {
    }

    public void setStartTime(LocalTime startTime) {
    }

    public void setEndTime(LocalTime endTime) {
    }

    public void setUpperTodoId(Long upperTodoId) {
    }

    public void setEnergyLevel(EnergyLevel energyLevel) {
    }

    // 반복 루틴
}
