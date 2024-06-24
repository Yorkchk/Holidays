package com.Youssef.Holidays.Services;

import com.Youssef.Holidays.Entities.Holiday;
import com.Youssef.Holidays.Entities.HolidayDTO;
import com.Youssef.Holidays.Repositories.HolidayRepo;
import com.Youssef.Holidays.ServiceInter.HolidayInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayService implements HolidayInter {

    @Autowired
    private HolidayRepo holidayRepo;


    public void saveHoliday(Holiday holiday) throws Exception {
    try {
        if (holiday.getStartDate().after(holiday.getEndDate())) {
            throw new Exception();
        }
        holidayRepo.save(holiday);
    }
    catch(Exception e){
        System.out.println("The end date can not be before the start date");
    }

    }

    public void deleteHolidayById(Long id){
        holidayRepo.deleteById(id);
    }

    public Holiday getHolidayById(Long id){
        return holidayRepo.findById(id).get();
    }

    public List<Holiday> getAllHolidays(){
        return holidayRepo.findAll();
    }

//    private Holiday convertToHoliday(HolidayDTO holidayDTO){
//        Holiday holiday = new Holiday()
//    }
}
