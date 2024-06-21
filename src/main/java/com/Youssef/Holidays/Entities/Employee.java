package com.Youssef.Holidays.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private Long EmpId;

    private String FirstName;

    private String LastName;

//    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
//    private List<Holiday> holidays = new ArrayList<>();

//    @ManyToOne
//    private ChefDepart chefDepart;

    @Column(name = "ChefDepartId", nullable = false)
    private Long chefDepartId;


}
