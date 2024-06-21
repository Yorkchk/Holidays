package com.Youssef.Holidays.Services;

import com.Youssef.Holidays.Entities.Holiday;
import com.Youssef.Holidays.Repositories.HolidayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayService {

    @Autowired
    private HolidayRepo holidayRepo;

    @Autowired
    private EmployeeService employeeService;

    public Holiday saveHoliday(Holiday holiday) throws Exception {
        try {
            if (employeeService.getEmployeeById(holiday.getEmpId()) == null) {
                throw new Exception();
            }
            return holidayRepo.save(holiday);
        }
        catch(Exception e){
            System.out.println("This employee does not exist");
        }
        return null;
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
}
