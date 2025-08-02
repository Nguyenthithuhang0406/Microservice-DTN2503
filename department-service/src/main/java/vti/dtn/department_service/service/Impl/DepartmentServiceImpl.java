package vti.dtn.department_service.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vti.dtn.department_service.dto.DepartmentDto;
import vti.dtn.department_service.entity.DepartmentEntity;
import vti.dtn.department_service.repository.DepartmentRepository;
import vti.dtn.department_service.service.DepartmentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities.stream()
                .map(departmentEntity -> DepartmentDto.builder()
                        .name(departmentEntity.getName())
                        .type(departmentEntity.getType().toString())
                        .createdDate(departmentEntity.getCreatedAt())
                        .build())
                .toList();
    }
}
