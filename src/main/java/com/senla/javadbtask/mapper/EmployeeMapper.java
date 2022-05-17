package com.senla.javadbtask.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senla.javadbtask.dto.EmployeeDto;
import com.senla.javadbtask.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    private final ObjectMapper mapper;

    public EmployeeMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public Employee convertToEntity(EmployeeDto employeeDto){
        return mapper.convertValue(employeeDto, Employee.class);
    }

    public EmployeeDto convertToDto(Employee employee){
        return mapper.convertValue(employee, EmployeeDto.class);
    }
}
