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

    public void postHolidayToRH( HolidayDTO holidayDTO) throws Exception {
        try {
            if (holidayService.getHolidayById(holidayDTO.getHolyId()).getStatusCD() != Status.Validated) {
                throw new Exception();
            }
            else if (holidayDTO.getStatus() == Status.InProgress) {
                throw new RuntimeException();
            }
            else if (holidayDTO.getStatus() == Status.Rejected) {
                holidayService.deleteHolidayById(holidayDTO.getHolyId());
                System.out.println("Holiday declined by RH");
//                return holidayService.getHolidayById(holidayDTO.getHolyId());
            }
            else {
                System.out.println("Validated by RH");
                Holiday holiday = holidayService.getHolidayById(holidayDTO.getHolyId());
                holiday.setStatusRH(Status.Validated);
                holidayService.saveHoliday(holiday);
                System.out.println("The holiday is validated");

            }
        }
        catch(RuntimeException e){
            System.out.println("The status can either be Validated or Rejected");
        }
        catch (Exception e) {
            System.out.println("Chef Departement needs to validate the holiday");
        }
//        return holidayService.getHolidayById(holidayDTO.getHolyId());
    }
}
