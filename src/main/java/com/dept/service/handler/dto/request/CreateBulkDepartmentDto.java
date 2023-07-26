package com.dept.service.handler.dto.request;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBulkDepartmentDto {
  private List<CreateDepartmentDto> departmentNames;
}
