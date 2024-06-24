package com.Youssef.Holidays.RestController;

import com.Youssef.Holidays.Entities.Employee;
import com.Youssef.Holidays.Entities.Holiday;
import com.Youssef.Holidays.Services.EmployeeService;
import com.Youssef.Holidays.Services.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping(path="/allEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/createEmployee")
    public void createEmployee(@RequestBody Employee employee) throws Exception{
        employeeService.saveEmployee(employee);
    }
}
