package com.Youssef.Holidays.Services;

import com.Youssef.Holidays.Entities.RH;
import com.Youssef.Holidays.Repositories.RHRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RHService {

    @Autowired
    private RHRepo rhRepo;

    public RH saveRH(RH rh){
        return rhRepo.save(rh);
    }

    public RH getRHById(Long id){
        return rhRepo.findById(id).get();
    }

    public List<RH> getAllRH(){
        return rhRepo.findAll();
    }
}
