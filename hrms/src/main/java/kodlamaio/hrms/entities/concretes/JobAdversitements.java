package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_adversitements")
public class JobAdversitements {

	@Column(name = "id")
	private int id;

	
	@Column(name = "description")
	private String description;
	
	@Column(name = "open_position_count")
	private int openPosition;
	
	@Column(name = "deadline")
	private LocalDate deadline;
	
	@Column(name = "created_at")
	private LocalDate createdAt;
	
	@Column(name = "is_open")
	private boolean isOpen;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	@Column(name = "salary_min")
	private int salaryMin;
	
	@Column(name = "salary_max")
	private int salaryMax;
	
	@Column(name = "publishhead_at")
	private LocalDate publisheadAt;
	
	

}
