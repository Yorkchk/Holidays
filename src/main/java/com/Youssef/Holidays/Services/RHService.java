package com.Youssef.Holidays.Services;

import com.Youssef.Holidays.Entities.Holiday;
import com.Youssef.Holidays.Entities.HolidayDTO;
import com.Youssef.Holidays.Entities.RH;
import com.Youssef.Holidays.Entities.Status;
import com.Youssef.Holidays.Repositories.RHRepo;
import com.Youssef.Holidays.ServiceInter.RHInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RHService implements RHInter {

    @Autowired
    private RHRepo rhRepo;

    @Autowired
    private HolidayService holidayService;

    public RH saveRH(RH rh){
        return rhRepo.save(rh);
    }

    public RH getRHById(Long id){
        return rhRepo.findById(id).get();
    }

    public List<RH> getAllRH(){
        return rhRepo.findAll();
    }

    public void rejectHoliday(Long id) throws Exception{
    try {
        if (holidayService.getHolidayById(id) == null) {
            throw new RuntimeException();
        } else if (holidayService.getHolidayById(id).getStatusCD() != Status.Validated) {
            throw new Exception();
        } else {
            Holiday holiday = holidayService.getHolidayById(id);
            holiday.setStatusRH(Status.Rejected);
            holidayService.saveHoliday(holiday);
            System.out.println("Holiday declined by RH");
        }
    }
    catch(RuntimeException e){
        System.out.println("the holiday does not exist");
    }
    catch(Exception e){
        System.out.println("the holiday needs to be validated by Chef department before going to RH");
    }
    }

    public void validateHolidayToRH( Long id) throws Exception {
        try {
            if (holidayService.getHolidayById(id) == null) {
                throw new RuntimeException();
            } else if (holidayService.getHolidayById(id).getStatusCD() != Status.Validated) {
                throw new Exception();
            }
            else {
                System.out.println("Validated by RH");
                Holiday holiday = holidayService.getHolidayById(id);
                holiday.setStatusRH(Status.Validated);
                holidayService.saveHoliday(holiday);
                System.out.println("The holiday is validated");
            }
        }
        catch(RuntimeException e){
            System.out.println("the holiday does not exist");
        }
        catch(Exception e){
            System.out.println("the holiday needs to be validated by Chef department before going to RH");
        }
//        return holidayService.getHolidayById(holidayDTO.getHolyId());
    }
}
