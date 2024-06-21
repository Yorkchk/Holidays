package com.Youssef.Holidays.RestController;

import com.Youssef.Holidays.Entities.ChefDepart;
import com.Youssef.Holidays.Entities.Holiday;
import com.Youssef.Holidays.Entities.Status;
import com.Youssef.Holidays.Services.ChefDepartService;
import com.Youssef.Holidays.Services.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/ChefDepart")

public class ChefDepartController {

    @Autowired
    private ChefDepartService chefDepartService;
    @Autowired
    private HolidayService holidayService;

    @PostMapping
    public Holiday postHolidayToCD(@RequestBody Holiday holiday) throws Exception{
    try {
        if (holiday.getStatusCD() == Status.InProgress) {
            throw new Exception();
        } else if (holiday.getStatusCD() == Status.Rejected) {
            holidayService.deleteHolidayById(holiday.getHolyId());
            System.out.println("Holiday declined by chef departement");
            return holiday;
        }
        holidayService.saveHoliday(holiday);
        System.out.println("Validated by Chef Departement");
    }
    catch(Exception e){
        System.out.println("the status can either be Validated or Rejected");
    }
        return holiday;
    }

    @PostMapping("/createCD")
    public ChefDepart createChefDepart(@RequestBody ChefDepart chefDepart) throws Exception{
        return chefDepartService.saveChefDepart(chefDepart);
    }

    @GetMapping
    public List<ChefDepart> getChefDeparts(){
        return chefDepartService.getAllChefDepart();
    }
}
