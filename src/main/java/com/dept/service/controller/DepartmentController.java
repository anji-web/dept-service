package com.dept.service.controller;

import com.dept.service.entities.Department;
import com.dept.service.handler.dto.request.CreateBulkDepartmentDto;
import com.dept.service.handler.dto.request.CreateDepartmentDto;
import com.dept.service.handler.dto.response.EmployeeDepartment;
import com.dept.service.repository.DepartmentRepository;
import com.dept.service.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api-v1/department")
public class DepartmentController {
  @Autowired
  private DepartmentService departmentService;

  @Autowired
  private DepartmentRepository departmentRepo;


  @PostMapping("create")
  public ResponseEntity createDepartment(@RequestBody CreateDepartmentDto createDepartmentDto) {
    try {
      String response = departmentService.createDepartment(createDepartmentDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PostMapping("create-bulk")
  public ResponseEntity createDepartmentBulk(@RequestBody
                                                 CreateBulkDepartmentDto createBulkDepartmentDto) {
    try {
      String response = departmentService.createDepartmentBulk(createBulkDepartmentDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("list-departments")
  public ResponseEntity getListDepartments() {
    return ResponseEntity.ok(departmentRepo.findAll());
  }

  @GetMapping("employee-department")
  public ResponseEntity getEmployeeDepartment(@RequestParam("employeeId") int employeeId) {
    EmployeeDepartment result = departmentRepo.getEmployeeDepartment(employeeId);
    return ResponseEntity.ok(result);
  }

  @GetMapping("detail")
  public ResponseEntity<Department> getDepartmentById(@RequestParam("departmentId") int departmentId) {
    return ResponseEntity.ok(departmentService.getDepartmentById(departmentId));
  }
}
