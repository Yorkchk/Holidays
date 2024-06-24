package com.Youssef.Holidays.Entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RH {

    @Id
    @GeneratedValue
    private Long RHId;

    @OneToMany
    private List<Holiday> holidays = new ArrayList<>();
}
