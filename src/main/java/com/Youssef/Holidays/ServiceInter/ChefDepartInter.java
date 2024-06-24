package com.Youssef.Holidays.ServiceInter;

import com.Youssef.Holidays.Entities.ChefDepart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChefDepartInter {

    ChefDepart saveChefDepart(ChefDepart chefDepart) throws Exception;

    ChefDepart getChefDepartById(Long id);

    List<ChefDepart> getAllChefDepart();
}
