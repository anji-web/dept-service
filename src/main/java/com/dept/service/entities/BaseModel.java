package com.dept.service.entities;

import java.util.Date;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class BaseModel {
  private Date createdDate;
  private Date updatedDate;
}
