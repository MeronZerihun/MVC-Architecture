package com.web.SE2.domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name="dean_announcements")
public class Announcement {  
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="created_at")
	private Date createdAt;
	
	
	@PrePersist
	void createdAt() {
		this.createdAt=new Date();
	}
	@NotEmpty(message="Header cannot be empty")
	@NotNull
	private String header;
	
	
	@NotEmpty(message="Description cannot be empty")
	private String detail;
	
	
}
