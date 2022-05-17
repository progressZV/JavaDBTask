package com.senla.javadbtask.repository.impl;

import com.senla.javadbtask.entity.Employee;
import com.senla.javadbtask.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class EmployeeRepositoryImpl extends AbstractDao<Employee, Integer> implements EmployeeRepository {

    public EmployeeRepositoryImpl(){
        super(Employee.class);
    }

    @Override
    public Employee getByBirthDate(Integer year) {
        return entityManager.createQuery(
                "SELECT employee FROM Employee employee WHERE employee.birthYear = :year", Employee.class)
                .setParameter("year", year).getSingleResult();
    }
}
