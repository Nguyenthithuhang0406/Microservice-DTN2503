package vti.dtn.department_service.service;

import vti.dtn.department_service.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> getAllDepartments();
}
