package com.Youssef.Holidays.RestController;

import com.Youssef.Holidays.Entities.Holiday;
import com.Youssef.Holidays.Entities.HolidayDTO;
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
    public void postHolidayToRH(@RequestBody HolidayDTO holidayDTO) throws Exception {
        rhService.postHolidayToRH(holidayDTO);
    }

    @GetMapping
    public List<RH> getRHs(){
        return rhService.getAllRH();
    }
}
