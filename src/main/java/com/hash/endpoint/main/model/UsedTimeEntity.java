package com.hash.endpoint.main.model;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class UsedTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long idPasswordEntity;

    private Long usedTime;

    private LocalDate lastTimeUsed;
}
