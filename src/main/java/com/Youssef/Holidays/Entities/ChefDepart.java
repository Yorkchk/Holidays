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
public class ChefDepart {

    @Id
    @GeneratedValue
    private Long ChefDepartId;


//    @Column(name = "RHId", nullable = false)
//    private Long rhId;

    @OneToMany
    private List<Holiday> holidays = new ArrayList<>();

}
