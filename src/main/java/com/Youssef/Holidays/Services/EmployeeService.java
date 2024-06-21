package com.Youssef.Holidays.Services;

import com.Youssef.Holidays.Entities.Employee;
import com.Youssef.Holidays.Repositories.ChefDepartRepo;
import com.Youssef.Holidays.Repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ChefDepartService chefDepartService;

    public Employee saveEmployee(Employee employee) throws Exception{
    try {
        if (chefDepartService.getChefDepartById(employee.getChefDepartId()) == null) {
            throw new Exception("Departement does not exist");
        }
        return employeeRepo.save(employee);
    }
    catch(Exception e){
        System.out.println("Department does not exist");
    }
        return null;
    }

    public void deleteEmployeeById(Long id){
        employeeRepo.deleteById(id);
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee getEmployeeById(Long id){
        return employeeRepo.findById(id).get();
    }

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
}
