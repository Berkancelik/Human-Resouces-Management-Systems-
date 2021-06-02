package kodlamaio.hrms.entities.concretes;


import  java.sql.Date;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "job_titles")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyIntilazier","handler","jobAdverts"})
public class JobTitle {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;
	
	@Column(name = "is_active")
	private boolean isActive = true;
	
	@Column(name="created_at")
	private Date createdDate;
	
	@Column(name = "is_deleted")
	private boolean isDeleted  = false;
	
	@OneToMany(mappedBy = "jobTitle")
	private List<JobAdversitements> jobAdversitements;
	
	


}
