package com.Youssef.Holidays.Services;

import com.Youssef.Holidays.Entities.ChefDepart;
import com.Youssef.Holidays.Repositories.ChefDepartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefDepartService {

    @Autowired
    private ChefDepartRepo chefDepartRepo;

    @Autowired
    private RHService rhService;

    public ChefDepart saveChefDepart(ChefDepart chefDepart) throws Exception{
    try {
        if (rhService.getRHById(chefDepart.getRhId()) == null) {
            throw new Exception("RH does not exist");
        }
        return chefDepartRepo.save(chefDepart);
    }
    catch(Exception e){
        System.out.println("RH does not exist");
    }
    return null;
    }

    public ChefDepart getChefDepartById(Long id){
        return chefDepartRepo.findById(id).get();
    }

    public List<ChefDepart> getAllChefDepart(){
        return chefDepartRepo.findAll();
    }
}
