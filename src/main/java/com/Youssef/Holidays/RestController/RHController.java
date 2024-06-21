package com.Youssef.Holidays.RestController;

import com.Youssef.Holidays.Entities.Holiday;
import com.Youssef.Holidays.Entities.RH;
import com.Youssef.Holidays.Entities.Status;
import com.Youssef.Holidays.Services.HolidayService;
import com.Youssef.Holidays.Services.RHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/RH")

public class RHController {

    @Autowired
    private RHService rhService;

    @Autowired
    HolidayService holidayService;

    @PostMapping("/createRH")
    public void createRH(@RequestBody RH rh) {
        rhService.saveRH(rh);
    }

    @PostMapping
    public Holiday postHolidayToRH(@RequestBody Holiday holiday) throws Exception {
        try {
            if (holiday.getStatusCD() != Status.Validated) {
                throw new Exception();
            }
            if (holiday.getStatusRH() == Status.Rejected) {
                holidayService.deleteHolidayById(holiday.getHolyId());
                System.out.println("Holiday declined by RH");
                return holiday;
            }
            System.out.println("Validated by RH");
            holidayService.saveHoliday(holiday);
        } catch (Exception e) {
            System.out.println("Chef Departement needs to validate the holiday");
        }
        return holiday;
    }

    @GetMapping
    public List<RH> getRHs(){
        return rhService.getAllRH();
    }
}
