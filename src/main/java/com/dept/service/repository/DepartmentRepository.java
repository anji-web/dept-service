package com.dept.service.repository;


import com.dept.service.entities.Department;
import com.dept.service.handler.dto.response.EmployeeDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
  public Department findDepartmentByDepartmentName(String departmentName);

  @Query(value = "select e.employee_id as employeeId, e.email as email, e.employee_name as employeeName , " +
      "d.department_name as department  \n" +
      "from employee e join department d on e.department_department_id = d.department_id\n" +
      "where e.employee_id = ?1", nativeQuery = true)
  public EmployeeDepartment getEmployeeDepartment(int employeeId);
}
