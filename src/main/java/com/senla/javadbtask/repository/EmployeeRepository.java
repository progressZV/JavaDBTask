package com.senla.javadbtask.repository;

import com.senla.javadbtask.entity.Employee;

import java.util.Date;

public interface EmployeeRepository extends GenericDao<Employee, Integer> {
    Employee getByBirthDate(Integer year);
}
