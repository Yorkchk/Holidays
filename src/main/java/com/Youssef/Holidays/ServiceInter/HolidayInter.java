package com.Youssef.Holidays.ServiceInter;

import com.Youssef.Holidays.Entities.Holiday;
import com.Youssef.Holidays.Entities.HolidayDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HolidayInter {

    Holiday saveHoliday(Holiday holiday) throws Exception;

    void deleteHolidayById(Long id);

    Holiday getHolidayById(Long id);

    List<Holiday> getAllHolidays();

}
