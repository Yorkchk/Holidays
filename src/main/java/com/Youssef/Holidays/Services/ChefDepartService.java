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

    public void postHolidayToCD(HolidayDTO holidayDTO) throws Exception{
        try {
            if (holidayDTO.getStatus() != Status.Validated && holidayDTO.getStatus() != Status.Rejected) {
                throw new Exception();
            }
            else if (holidayService.getHolidayById(holidayDTO.getHolyId()) == null){
                throw new RuntimeException();
            }
            else if (holidayDTO.getStatus() == Status.Rejected) {
                holidayService.deleteHolidayById(holidayDTO.getHolyId());
                System.out.println("Holiday declined by chef departement");
            }
            else {
                Holiday holiday = holidayService.getHolidayById(holidayDTO.getHolyId());
                holiday.setStatusCD(Status.Validated);
                holidayService.saveHoliday(holiday);
                System.out.println("Validated by Chef Departement");
            }
        }
        catch(RuntimeException e){
            System.out.println("This employee does not exist");
        }
        catch(Exception e){
            System.out.println("the status can either be Validated or Rejected");
        }
//        return holidayService.getHolidayById(holidayDTO.getHolyId());
    }
}
