package com.senla.javadbtask.controller;

import com.senla.javadbtask.dto.EmployeeDto;
import com.senla.javadbtask.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeDto save(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }

    @GetMapping(value = "/{id}")
    public EmployeeDto read(@PathVariable Integer id){
        return employeeService.getEmployee(id);
    }

    @GetMapping
    public EmployeeDto getByBirthDate(@RequestParam("year") Integer year){
        return employeeService.getByBirthDate(year);
    }

    @PutMapping
    public EmployeeDto update(@RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(employeeDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
    }
}
