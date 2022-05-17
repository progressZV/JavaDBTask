package com.senla.javadbtask.service.impl;

import com.senla.javadbtask.dto.EmployeeDto;
import com.senla.javadbtask.entity.Employee;
import com.senla.javadbtask.mapper.EmployeeMapper;
import com.senla.javadbtask.repository.EmployeeRepository;
import com.senla.javadbtask.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    @Transactional
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.convertToEntity(employeeDto);
        return employeeMapper.convertToDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDto getEmployee(Integer id) {
        Employee employee = employeeRepository.read(id);
        return employeeMapper.convertToDto(employee);
    }

    @Override
    @Transactional
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.convertToEntity(employeeDto);
        return employeeMapper.convertToDto(employeeRepository.update(employee));
    }

    @Override
    @Transactional
    public void deleteEmployee(Integer id) {
        employeeRepository.delete(id);
    }

    @Override
    public EmployeeDto getByBirthDate(Integer year) {
        Employee employee = employeeRepository.getByBirthDate(year);
        return employeeMapper.convertToDto(employee);
    }

}
