package com.hash.endpoint.main.model;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class PasswordEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hashType;

    private String password;

    private String hash;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = UsedTimeEntity.class)
    private UsedTimeEntity usedTimeEntities;
}
