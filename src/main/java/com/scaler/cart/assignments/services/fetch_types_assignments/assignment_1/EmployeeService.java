package com.scaler.cart.assignments.services.fetch_types_assignments.assignment_1;

import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_1.Employee;
import com.scaler.cart.assignments.repo.fetch_types_assignments.assignment_1.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee getEmployeeDetails(Long empId) {
        Optional<Employee> repoResponse = this.employeeRepo.findById(empId);
        if (repoResponse.isEmpty()) {
            throw new RuntimeException("Employee details not found");
        }
        return repoResponse.get();
    }
}
