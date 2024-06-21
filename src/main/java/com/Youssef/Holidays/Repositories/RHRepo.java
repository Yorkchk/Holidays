package com.Youssef.Holidays.Repositories;

import com.Youssef.Holidays.Entities.RH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHRepo extends JpaRepository<RH, Long> {
}
