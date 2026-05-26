package com.anjan.employee_api.service;

import com.anjan.employee_api.dto.DepartmentDTO;
import com.anjan.employee_api.entity.Department;
import com.anjan.employee_api.exception.DepartmentNotFoundException;
import com.anjan.employee_api.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentDTO createDepartment(Department department) {
        Department saved = departmentRepository.save(department);
        return convertToDTO(saved);
    }

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public DepartmentDTO getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
        return convertToDTO(department);
    }

    public DepartmentDTO updateDepartment(Long id, Department department) {
        departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
        department.setId(id);
        Department updated = departmentRepository.save(department);
        return convertToDTO(updated);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
        departmentRepository.deleteById(id);
    }

    private DepartmentDTO convertToDTO(Department department) {
        List<String> employeeNames = department.getEmployees()
                .stream()
                .map(e -> e.getName())
                .collect(Collectors.toList());
        return new DepartmentDTO(
                department.getId(),
                department.getName(),
                department.getDescription(),
                employeeNames
        );
    }
}