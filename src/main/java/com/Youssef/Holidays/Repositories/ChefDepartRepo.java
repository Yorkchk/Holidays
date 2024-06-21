package com.Youssef.Holidays.Repositories;

import com.Youssef.Holidays.Entities.ChefDepart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefDepartRepo extends JpaRepository<ChefDepart, Long> {
}
