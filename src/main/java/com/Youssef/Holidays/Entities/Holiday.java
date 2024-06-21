package com.Youssef.Holidays.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Holiday {

    @Id
    @GeneratedValue
    private Long HolyId;

    @NotNull
    private Date startDate;

    @NotNull
    private Date EndDate;

    private Status StatusCD = Status.InProgress;

    private Status StatusRH = Status.InProgress;

    @Column(name = "emp_id", nullable = false)
    private Long empId;
}
