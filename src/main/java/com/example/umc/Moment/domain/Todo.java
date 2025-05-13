package com.example.umc.Moment.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor
public class Todo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Setter
    @Column(nullable = false, length = 100)
    private String title;

    @Setter
    private LocalDate date;

    @Setter
    private LocalTime startTime;

    @Setter
    private LocalTime endTime;

    @Setter
    @Enumerated(EnumType.STRING)
    private EnergyLevel energyLevel;

    @Setter
    private Long upperTodoId;

    // 반복 루틴
}
