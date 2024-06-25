package com.Youssef.Holidays.Services;

import com.Youssef.Holidays.Entities.ChefDepart;
import com.Youssef.Holidays.Entities.Holiday;
import com.Youssef.Holidays.Entities.HolidayDTO;
import com.Youssef.Holidays.Entities.Status;
import com.Youssef.Holidays.Repositories.ChefDepartRepo;
import com.Youssef.Holidays.ServiceInter.ChefDepartInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ChefDepartService implements ChefDepartInter {

    @Autowired
    private ChefDepartRepo chefDepartRepo;


    @Autowired
    private HolidayService holidayService;

    public ChefDepart saveChefDepart(ChefDepart chefDepart) throws Exception{
        return chefDepartRepo.save(chefDepart);
    }

    public ChefDepart getChefDepartById(Long id){
        return chefDepartRepo.findById(id).get();
    }

    public List<ChefDepart> getAllChefDepart(){
        return chefDepartRepo.findAll();
    }

    public void rejectHolidayCD(Long id) throws Exception{
    try {
        if (holidayService.getHolidayById(id) == null) {
            throw new RuntimeException();
        }
        Holiday holiday = holidayService.getHolidayById(id);
        holiday.setStatusCD(Status.Rejected);
        holidayService.saveHoliday(holiday);
        System.out.println("Holiday declined by chef departement");
        }
    catch(RuntimeException e){
        System.out.println("This holiday does not exist");
        }
    }

    public void validateHolidayToCD(Long id) throws Exception{
        try {
            if (holidayService.getHolidayById(id) == null){
                throw new RuntimeException();
            }

            else {
                Holiday holiday = holidayService.getHolidayById(id);
                holiday.setStatusCD(Status.Validated);
                holidayService.saveHoliday(holiday);
                System.out.println("Validated by Chef Departement");
            }
        }
        catch(RuntimeException e){
            System.out.println("The holiday does not exist");
        }
//        return holidayService.getHolidayById(holidayDTO.getHolyId());
    }
}
