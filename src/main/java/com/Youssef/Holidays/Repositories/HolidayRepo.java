package com.Youssef.Holidays.Repositories;

import com.Youssef.Holidays.Entities.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepo extends JpaRepository<Holiday, Long> {
}
