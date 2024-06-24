package com.Youssef.Holidays.RestController;

import com.Youssef.Holidays.Entities.Holiday;
import com.Youssef.Holidays.Entities.HolidayDTO;
import com.Youssef.Holidays.Entities.Status;
import com.Youssef.Holidays.Services.EmployeeService;
import com.Youssef.Holidays.Services.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/Holiday")
public class HolidayController {

    @Autowired
    HolidayService holidayService;



    @GetMapping("/allHolidays")
    public List<Holiday> getHolidays(){
        return holidayService.getAllHolidays();
    }

    @GetMapping("/{id}")
    public Holiday getHolidayById(@PathVariable("id") Long id){
        return holidayService.getHolidayById(id);
    }


    @PostMapping
    public void createHoliday(@RequestBody Holiday holiday) throws Exception{
            holidayService.saveHoliday(holiday);
    }

    @DeleteMapping("/{id}")
    public void deleteHolidayById(@PathVariable("id") Long id){
        holidayService.deleteHolidayById(id);
    }


}
