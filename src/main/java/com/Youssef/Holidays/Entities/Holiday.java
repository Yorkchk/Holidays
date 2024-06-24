package com.Youssef.Holidays.Entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
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

//    @Column(name = "emp_id", nullable = false)
//    private Long empId;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private ChefDepart chefDepart;

    @ManyToOne
    private RH rh;
}
