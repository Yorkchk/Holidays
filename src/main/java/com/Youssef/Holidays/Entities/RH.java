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
public class RH {

    @Id
    @GeneratedValue
    private Long RHId;

//    @OneToMany(mappedBy = "rh", fetch = FetchType.LAZY)
//    private List<ChefDepart> chefDeparts = new ArrayList<>();
}
