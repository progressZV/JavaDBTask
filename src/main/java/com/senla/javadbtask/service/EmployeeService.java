package com.senla.javadbtask.service;

import com.senla.javadbtask.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(Integer id);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
    void deleteEmployee(Integer id);
    EmployeeDto getByBirthDate(Integer year);
}
