package com.Youssef.Holidays.RestController;

import com.Youssef.Holidays.Entities.ChefDepart;
import com.Youssef.Holidays.Entities.Holiday;
import com.Youssef.Holidays.Entities.HolidayDTO;
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

    @PostMapping("/{id}/Validate")
    public void validateHolidayToCD(@PathVariable Long id) throws Exception{
        chefDepartService.validateHolidayToCD(id);
    }

    @PostMapping("/{id}/Reject")
    public void rejectHolidayToCD(@PathVariable Long id) throws Exception{
        chefDepartService.rejectHolidayCD(id);
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
