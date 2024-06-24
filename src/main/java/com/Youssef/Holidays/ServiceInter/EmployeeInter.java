package com.Youssef.Holidays.ServiceInter;

import com.Youssef.Holidays.Entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeInter {

    Employee saveEmployee(Employee employee) throws Exception;

    void deleteEmployeeById(Long id);

    Employee updateEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();
}
