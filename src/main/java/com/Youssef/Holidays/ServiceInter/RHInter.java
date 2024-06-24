package com.Youssef.Holidays.ServiceInter;

import com.Youssef.Holidays.Entities.RH;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RHInter {

    RH saveRH(RH rh);

    RH getRHById(Long id);

    List<RH> getAllRH();
}
