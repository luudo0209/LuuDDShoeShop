package com.luudd.entity;

import lombok.Data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BaseEntity {
	
	@Column
	private String createdBy;
	@Column
	private Date createdAt;
	@Column
	private String updatedBy;
	@Column
	private Date updatedAt;
}
